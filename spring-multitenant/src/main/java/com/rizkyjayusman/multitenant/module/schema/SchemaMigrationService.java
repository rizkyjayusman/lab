package com.rizkyjayusman.multitenant.module.schema;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchemaMigrationService {

    private final JdbcTemplate jdbcTemplate;
    private final SchemaMigrationPolicy schemaMigrationPolicy;
    private final FlywayMigrationService flywayMigrationService;

    public void migrate(String tenantCode) {
        schemaMigrationPolicy.validateTenantCode(tenantCode);

        String schemaName = getTenantSchemaName(tenantCode);
        schemaMigrationPolicy.validateSchemaName(schemaName);
        schemaMigrationPolicy.validateTenantSchemaUrl(schemaName);

        createNewSchema(schemaName);
        flywayMigrationService.migrate(schemaName);
    }

    private String getTenantSchemaName(String tenantCode) {
        return tenantCode.toLowerCase().replace(" ", "_");
    }

    private void createNewSchema(String schemaName) {
        String sql = getCreateNewSchemaSql(schemaName);
        jdbcTemplate.execute(sql);
    }

    private String getCreateNewSchemaSql(String schemaName) {
        return String.format("CREATE SCHEMA IF NOT EXISTS %s", schemaName);
    }
}
