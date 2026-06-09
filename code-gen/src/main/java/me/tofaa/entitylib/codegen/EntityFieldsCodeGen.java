package me.tofaa.entitylib.codegen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class EntityFieldsCodeGen {

    private static final String VERSIONS_URL = "https://kennytv.eu/entity-data/versions.json";
    private static final String DATA_URL_FORMAT = "https://kennytv.eu/entity-data/%s.json";
    private static final String OUTPUT_DIR = "src/main/java/me/tofaa/entitylib/meta/types";

    private static final Set<String> EXCLUDED_VERSIONS = Set.of("26.2");

    public static final Comparator<String> VERSION_COMPARATOR = (v1, v2) -> {
        String[] p1 = v1.split("\\.");
        String[] p2 = v2.split("\\.");
        int length = Math.max(p1.length, p2.length);
        for (int i = 0; i < length; i++) {
            int n1 = i < p1.length ? Integer.parseInt(p1[i]) : 0;
            int n2 = i < p2.length ? Integer.parseInt(p2[i]) : 0;
            if (n1 != n2) return Integer.compare(n1, n2);
        }
        return 0;
    };

    public static void main(String[] args) {
        System.out.println("Starting OOP EntityFields code generator...");

        DataTypeMapper mapper = new DataTypeMapper();
        Map<String, EntityNode> entities = new TreeMap<>();

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest versionsReq = HttpRequest.newBuilder().uri(URI.create(VERSIONS_URL)).build();
            HttpResponse<String> versionsRes = client.send(versionsReq, HttpResponse.BodyHandlers.ofString());

            List<String> fullVersions = fetchValidVersions(versionsRes.body());
            fullVersions.sort(VERSION_COMPARATOR);

            ClassWriter writer = new ClassWriter(OUTPUT_DIR, fullVersions);

            for (String version : fullVersions) {
                System.out.println("Processing version [" + version + "]...");

                String url = String.format(DATA_URL_FORMAT, version);
                HttpRequest dataReq = HttpRequest.newBuilder().uri(URI.create(url)).build();
                HttpResponse<String> dataRes = client.send(dataReq, HttpResponse.BodyHandlers.ofString());

                JsonElement parsedElement = JsonParser.parseString(dataRes.body());
                if (parsedElement == null || !parsedElement.isJsonObject()) continue;
                JsonObject jsonEntities = parsedElement.getAsJsonObject();

                for (Map.Entry<String, JsonElement> entityEntry : jsonEntities.entrySet()) {
                    String rawName = entityEntry.getKey();
                    String className = cleanClassName(rawName) + "DataKeys";

                    EntityNode node = entities.computeIfAbsent(className, EntityNode::new);
                    node.getSupportedVersions().add(version);

                    if (!entityEntry.getValue().isJsonObject()) continue;
                    JsonObject body = entityEntry.getValue().getAsJsonObject();

                    if (node.getSuperClass() == null) {
                        if (body.has("superClass") && !body.get("superClass").isJsonNull()) {
                            String rawSuper = body.get("superClass").getAsString();
                            node.setSuperClass(cleanClassName(rawSuper) + "DataKeys");
                        }
                    }

                    if (!body.has("fields") || body.get("fields").isJsonNull()) continue;
                    JsonArray fieldsList = body.getAsJsonArray("fields");

                    for (JsonElement fieldObj : fieldsList) {
                        if (!fieldObj.isJsonObject()) continue;
                        JsonObject props = fieldObj.getAsJsonObject();
                        int index = props.get("index").getAsInt();
                        String dataType = props.get("dataType").getAsString();
                        String fieldName = props.get("fieldName").getAsString();

                        PropertyNode propNode = node.getProperties().computeIfAbsent(fieldName, PropertyNode::new);

                        propNode.setTypeMapping(mapper.mapDataType(dataType));
                        propNode.getVersions().put(version, new FieldData(index, dataType));
                    }
                }
            }

            System.out.println("Generating class files...");
            for (EntityNode node : entities.values()) {
                writer.writeClassFile(node, mapper);
            }

            System.out.println("Success! All OOP entity configurations generated.");

        } catch (Exception e) {
            throw new IllegalStateException("Something went wrong", e);
        }
    }

    private static List<String> fetchValidVersions(String jsonBody) {
        JsonElement parsedElement = JsonParser.parseString(jsonBody);
        List<String> filtered = new ArrayList<>();

        if (parsedElement != null && parsedElement.isJsonArray()) {
            JsonArray rawVersions = parsedElement.getAsJsonArray();
            for (JsonElement obj : rawVersions) {
                String version = obj.getAsString().trim();
                if (version.matches("^\\d+(\\.\\d+)*$") && !EXCLUDED_VERSIONS.contains(version)) {
                    filtered.add(version);
                }
            }
        }
        return filtered;
    }

    private static String cleanClassName(String rawInput) {
        if (rawInput == null || rawInput.isEmpty()) return "UnknownEntity";
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : rawInput.toCharArray()) {
            if (c == ' ' || c == '_' || c == '-') {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                sb.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}