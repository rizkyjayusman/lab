package com.rizkyjayusman.multitenant.module.schema;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchemaMigrationPolicy {

    @Value("${spring.flyway.reserved-schemas}")
    private List<String> reservedSchemas;

    public void validateSchemaName(String schemaName) {
        if (StringUtils.isBlank(schemaName)) {
            throw new IllegalArgumentException("Tenant schema name is required");
        }
    }

    public void validateTenantCode(String tenantCode) {
        if (StringUtils.isBlank(tenantCode)) {
            throw new IllegalArgumentException("Tenant code is required");
        }
    }

    public void validateTenantSchemaUrl(String tenantUrl) {
        if (StringUtils.isBlank(tenantUrl) || isReservedSchemaUrl(tenantUrl)) {
            throw new IllegalArgumentException("Base url is required");
        }
    }

    private boolean isReservedSchemaUrl(String tenantUrl) {
        for (String reservedSchema : reservedSchemas) {
            if (tenantUrl.startsWith(SchemaMigrationConstant.CURRENT_SCHEMA_PATH + reservedSchema)) {
                return true;
            }
        }

        return false;
    }
}
