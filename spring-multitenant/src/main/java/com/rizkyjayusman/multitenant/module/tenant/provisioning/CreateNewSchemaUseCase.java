package com.rizkyjayusman.multitenant.module.tenant.provisioning;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewSchemaUseCase {

    private final JdbcTemplate jdbcTemplate;

    public void handle(String schemaName) {
        String sql = getCreateNewSchemaSql(schemaName);
        jdbcTemplate.execute(sql);
    }

    private String getCreateNewSchemaSql(String schemaName) {
        return String.format("CREATE SCHEMA IF NOT EXISTS %s", schemaName);
    }
}
