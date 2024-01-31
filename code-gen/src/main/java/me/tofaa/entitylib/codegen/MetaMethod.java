package me.tofaa.entitylib.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;
import java.util.List;

public record MetaMethod(
        String name,
        String returnType,
        String defaultReturn,
        String dataType,
        List<VersionCheck> versionChecks
) {

    public List<MethodSpec> create() {
        String[] nameSplit = name.split(":");
        String[] returnSplit = returnType.split(":");
        String namePackage = nameSplit[0];
        String nameClass = nameSplit[1];
        String returnPackage = returnSplit[0];
        String returnClass = returnSplit[1];

        String methodBasedName = nameClass.substring(0, 1).toUpperCase() + nameClass.substring(1);

        /* offset calculator first */
        MethodSpec.Builder calculator = MethodSpec.methodBuilder(
                "calculate" + methodBasedName + "Offset")
                .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
                .addParameter(int.class, "version");
        for (VersionCheck check : versionChecks) {
            calculator.beginControlFlow("if (version >= $L && version <= $L)", check.from(), check.to());
            calculator.addStatement("return $L", check.offset());
            calculator.endControlFlow();
        }
        // throw exception if version is not in range
        calculator.addStatement("throw new IllegalArgumentException(\"Version \" + version + \" is not in range\")");

        String versionVariable = "byte offset = calculate" + methodBasedName + "Offset(EntityLib.getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion())";

        /* getter method spec. No params */
        MethodSpec.Builder getter = MethodSpec.methodBuilder("get" + methodBasedName)
                .addModifiers(Modifier.PUBLIC)
                .returns(ClassName.get(returnPackage, returnClass))
                .addStatement(versionVariable)
                .addStatement("return metadata.getIndex(" + "offset," + defaultReturn);

        MethodSpec.Builder setter = MethodSpec.methodBuilder("set" + methodBasedName)
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(ClassName.get(returnPackage, returnClass), "value")
                .addStatement(versionVariable)
                .addStatement("metadata.setIndex(" + "offset, " + dataType + ", " + "value");

        return List.of(
                calculator.build(),
                getter.build(),
                setter.build()
        );
    }

    public record VersionCheck(int from, int to, byte offset) {}

}
