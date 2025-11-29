package com.rizkyjayusman.multitenant.module.tenant.provisioning;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MigrateNewSchemaUseCase {

    private final FlywayMigrationService flywayMigrationService;

    public void handle(String schemaName) {
        flywayMigrationService.migrate(schemaName);
    }
}
