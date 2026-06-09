package me.tofaa.entitylib.codegen;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class ClassWriter {

    private final File outputDir;
    private final List<String> allVersions;

    public ClassWriter(String outputDirPath, List<String> allVersions) {
        this.outputDir = new File(outputDirPath);
        this.allVersions = allVersions;
        if (!this.outputDir.mkdirs() && !this.outputDir.exists()) {
            throw new RuntimeException("Can't create output dir");
        }
    }

    public void writeClassFile(EntityNode node, DataTypeMapper mapper) {
        Set<String> imports = new TreeSet<>();
        imports.add("me.tofaa.entitylib.meta.EntityDataKey");
        imports.add("com.github.retrooper.packetevents.protocol.player.ClientVersion");
        imports.add("com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes");

        StringBuilder bodySb = new StringBuilder();

        for (PropertyNode prop : node.getProperties().values()) {
            if (prop.getTypeMapping() == null || prop.getTypeMapping().isExcluded()) continue;

            prop.getTypeMapping().typeToken().appendImports(imports);
            String typeString = prop.getTypeMapping().typeToken().formatString();

            String canonicalRawType = lastValue(prop.getVersions()).rawDataType();
            TypeMapping canonicalMapping = mapper.mapDataType(canonicalRawType);

            bodySb.append(generateJavadoc(prop.getVersions().keySet(), "    "));

            bodySb.append("    public static final EntityDataKey<").append(typeString).append("> ")
                    .append(prop.getName())
                    .append(" = EntityDataKey.<").append(typeString).append(">builder(")
                    .append(node.getClassName()).append(".class)\n");

            for (Map.Entry<String, FieldData> versionEntry : prop.getVersions().entrySet()) {
                String enumVersion = "V_" + versionEntry.getKey().replace('.', '_');
                FieldData fieldData = versionEntry.getValue();
                String versionRawType = fieldData.rawDataType();

                TypeMapping versionMapping = mapper.mapDataType(versionRawType);

                boolean typesMatch = versionRawType.equals(canonicalRawType) ||
                        (versionMapping != null && canonicalMapping != null &&
                                Objects.equals(versionMapping.packetEventsDataType(), canonicalMapping.packetEventsDataType()));

                if (versionMapping != null && !versionMapping.isExcluded() && typesMatch) {
                    bodySb.append("            .addVersion(ClientVersion.").append(enumVersion)
                            .append(", ").append(fieldData.index())
                            .append(", EntityDataTypes.").append(versionMapping.packetEventsDataType()).append(")\n");
                } else {
                    bodySb.append("            // TODO type changed from '").append(versionRawType)
                            .append("' to '").append(canonicalRawType)
                            .append("', converter required\n");
                }
            }
            bodySb.append("            .build();\n\n");
        }

        StringBuilder finalStr = new StringBuilder();

        finalStr.append("// Auto-generated file. Do not edit manually.\n");
        finalStr.append("package me.tofaa.entitylib.meta.types;\n\n");

        for (String imp : imports) {
            finalStr.append("import ").append(imp).append(";\n");
        }
        finalStr.append("\n");

        finalStr.append(generateJavadoc(node.getSupportedVersions(), ""));

        String extendsClause = node.getSuperClass() != null ? " extends " + node.getSuperClass() : "";
        finalStr.append("public class ").append(node.getClassName()).append(extendsClause).append(" {\n\n");
        finalStr.append(bodySb);
        finalStr.append("}\n");

        try (FileWriter writer = new FileWriter(new File(this.outputDir, node.getClassName() + ".java"))) {
            writer.write(finalStr.toString());
        } catch (Exception e) {
            System.err.println("Failed to write " + node.getClassName());
        }
    }

    private static <V> V lastValue(Map<String, V> sortedMap) {
        Map.Entry<String, V> last = null;
        for (Map.Entry<String, V> e : sortedMap.entrySet()) {
            last = e;
        }
        if (last == null) throw new NoSuchElementException("Empty versions map");
        return last.getValue();
    }

    private String generateJavadoc(Set<String> supportedVersions, String indent) {
        if (supportedVersions.isEmpty()) return "";

        List<Integer> indices = new ArrayList<>();
        for (String v : supportedVersions) {
            int idx = this.allVersions.indexOf(v);
            if (idx != -1) indices.add(idx);
        }
        Collections.sort(indices);

        if (indices.isEmpty()) return "";

        List<String> ranges = new ArrayList<>();
        int startIdx = indices.get(0);
        int prevIdx = startIdx;

        for (int i = 1; i <= indices.size(); i++) {
            boolean endOfList = (i == indices.size());
            int currIdx = endOfList ? -1 : indices.get(i);

            if (endOfList || currIdx != prevIdx + 1) {
                if (startIdx == 0 && prevIdx == this.allVersions.size() - 1) {
                    ranges.add("All versions");
                } else if (startIdx == 0) {
                    ranges.add(this.allVersions.get(prevIdx) + "-");
                } else if (prevIdx == this.allVersions.size() - 1) {
                    ranges.add(this.allVersions.get(startIdx) + "+");
                } else if (startIdx == prevIdx) {
                    ranges.add(this.allVersions.get(startIdx));
                } else {
                    ranges.add(this.allVersions.get(startIdx) + " - " + this.allVersions.get(prevIdx));
                }

                if (!endOfList) {
                    startIdx = currIdx;
                    prevIdx = currIdx;
                }
            } else {
                prevIdx = currIdx;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("/**\n");
        sb.append(indent).append(" * Supported versions: ").append(String.join(", ", ranges)).append("\n");
        sb.append(indent).append(" */\n");
        return sb.toString();
    }
}