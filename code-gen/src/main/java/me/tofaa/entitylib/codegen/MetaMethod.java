package me.tofaa.entitylib.codegen;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.List;

public record MetaMethod(
        String name,
        Type returnType,
        String defaultReturn,
        String dataType,
        List<VersionCheck> versionChecks
) {

    public List<MethodSpec> create() {

        String methodBasedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        /* offset calculator first */
        MethodSpec.Builder calculator = MethodSpec.methodBuilder(
                "calculate" + methodBasedName + "Offset")
                .returns(byte.class)
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
        String getterName = "get";
        if (returnType == TypeName.BOOLEAN) {
            getterName = "is";
        }
        MethodSpec.Builder getter = MethodSpec.methodBuilder(getterName + methodBasedName)
                .addModifiers(Modifier.PUBLIC)
                .returns(returnType)
                .addStatement(versionVariable)
                .addStatement("return metadata.getIndex(" + "offset," + defaultReturn + ");");

        MethodSpec.Builder setter = MethodSpec.methodBuilder("set" + methodBasedName)
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(returnType, "value")
                .addStatement(versionVariable)
                .addStatement("metadata.setIndex(" + "offset, " + dataType + ", " + "value" + ");");

        return List.of(
                calculator.build(),
                getter.build(),
                setter.build()
        );
    }

}
