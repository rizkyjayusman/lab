package com.rizkyjayusman.multitenant.module.schema;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlywayMigrationService {

    private final SchemaConfig schemaConfig;

    @Value("${spring.flyway.migration-path}")
    private String migrationPath;

    public void migrate(String schemaName) {
        String schemaHost = getTenantSchemaUrl(schemaName);
        Flyway flyway = Flyway.configure()
                .dataSource(schemaHost, schemaConfig.getUsername(), schemaConfig.getPassword())
                .schemas(schemaName)
                .locations(getSchemaLocationPath())
                .baselineOnMigrate(true)
                .cleanDisabled(false)
                .load();

        flyway.migrate();
    }


    private String getSchemaLocationPath() {
        return String.format("classpath:%s", migrationPath);
    }

    private String getTenantSchemaUrl(String tenantUrl) {
        return schemaConfig.getBaseUrl().replace(SchemaMigrationConstant.CURRENT_SCHEMA, SchemaMigrationConstant.CURRENT_SCHEMA_PATH + tenantUrl);
    }
}
