package com.rizkyjayusman.multitenant.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver<String> {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantIdentifier = Optional.ofNullable(TenantContext.getCurrentTenant()).orElse(TenantContext.DEFAULT_TENANT_ID);
        log.info("getConnection() called for tenant: {}", tenantIdentifier);
        return tenantIdentifier;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
