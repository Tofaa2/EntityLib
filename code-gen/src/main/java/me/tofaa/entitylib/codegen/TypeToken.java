package me.tofaa.entitylib.codegen;

import java.util.Set;

public record TypeToken(String formatString, Class<?>... classesToImport) {

    public void appendImports(Set<String> imports) {
        for (Class<?> clazz : this.classesToImport) {
            if (clazz.isPrimitive()) continue;
            if (clazz.isArray()) clazz = clazz.getComponentType();
            if (clazz.getPackageName().equals("java.lang")) continue;

            imports.add(clazz.getCanonicalName());
        }
    }

}
