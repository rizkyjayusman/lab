package com.rizkyjayusman.multitenant.module.tenant.provisioning;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchemaNameGenerator {

    private final TenantProvisioningPolicy tenantProvisioningPolicy;

    public String generate(String tenantCode) {
        String schemaName = getTenantSchemaName(tenantCode);
        tenantProvisioningPolicy.validateSchemaName(schemaName);
        tenantProvisioningPolicy.validateTenantSchemaUrl(schemaName);

        return schemaName;
    }

    private String getTenantSchemaName(String tenantCode) {
        return tenantCode.toLowerCase().replace(" ", "_");
    }
}
