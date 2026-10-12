package me.tofaa.entitylib.codegen.schema;

import java.util.List;

public record TypeDef(String name, String wire, String java, List<String> upstream, String since, String removed,
                      String value, String convert) {

    public String valueJava() {
        return value != null ? value : java;
    }

}
