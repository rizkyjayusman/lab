package com.rizkyjayusman.multitenant.module.schema;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SchemaMigrationConstant {
    public static final String CURRENT_SCHEMA_PATH = "currentSchema=";
    public static final String CURRENT_SCHEMA = CURRENT_SCHEMA_PATH + "public";
}
