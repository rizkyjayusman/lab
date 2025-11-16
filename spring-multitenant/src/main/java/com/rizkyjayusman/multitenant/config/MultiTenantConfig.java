package com.rizkyjayusman.multitenant.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MultiTenantConfig {

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(TenantConnectionProvider connectionProvider, TenantIdentifierResolver resolver) {
        return hibernateProperties -> {
            hibernateProperties.put(
                    org.hibernate.cfg.MultiTenancySettings.MULTI_TENANT_CONNECTION_PROVIDER,
                    connectionProvider);
            hibernateProperties.put(
                    org.hibernate.cfg.MultiTenancySettings.MULTI_TENANT_IDENTIFIER_RESOLVER,
                    resolver);
        };
    }
}