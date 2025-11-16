package com.rizkyjayusman.multitenant.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
@Slf4j
public class TenantConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl<String> {

    private final DataSource dataSource;

    @Override
    protected DataSource selectAnyDataSource() {
        return dataSource;
    }

    @Override
    protected DataSource selectDataSource(String o) {
        log.info("Selecting data source");
        return dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        log.info("Connecting to database");
        return dataSource.getConnection();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        log.info("get connection : {}", tenantIdentifier);
        Connection connection = dataSource.getConnection();
        connection.createStatement().execute(String.format("SET search_path TO %s;", tenantIdentifier));
        return connection;
    }
}
