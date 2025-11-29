package com.rizkyjayusman.multitenant.module.tenant.provisioning;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantProvisioningService {

    private final JdbcTemplate jdbcTemplate;
    private final TenantProvisioningPolicy tenantProvisioningPolicy;
    private final FlywayMigrationService flywayMigrationService;

    public void migrate(String tenantCode) {
        tenantProvisioningPolicy.validateTenantCode(tenantCode);

        String schemaName = getTenantSchemaName(tenantCode);
        tenantProvisioningPolicy.validateSchemaName(schemaName);
        tenantProvisioningPolicy.validateTenantSchemaUrl(schemaName);

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
