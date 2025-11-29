package com.rizkyjayusman.multitenant.module.tenant.provisioning;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OnboardNewTenantUseCase {

    private final CreateNewSchemaUseCase createNewSchemaUseCase;
    private final MigrateNewSchemaUseCase migrateNewSchemaUseCase;
    private final SchemaNameGenerator schemaNameGenerator;
    private final TenantProvisioningPolicy tenantProvisioningPolicy;

    public void migrate(String tenantCode) {
        tenantProvisioningPolicy.validateTenantCode(tenantCode);

        String schemaName = schemaNameGenerator.generate(tenantCode);
        createNewSchemaUseCase.handle(schemaName);
        migrateNewSchemaUseCase.handle(schemaName);
    }
}
