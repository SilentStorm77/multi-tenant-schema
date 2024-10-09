package com.example.multi_tenant_schema.provider;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Component
public class ConnectionProvider implements MultiTenantConnectionProvider, HibernatePropertiesCustomizer {

    private DataSource dataSource;

    public ConnectionProvider(){

    }

    public ConnectionProvider(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return getConnection("PUBLIC");
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException{
        connection.close();
    }

    @Override
    public Connection getConnection(Object tenantIdentifier) throws SQLException {
        var connection = dataSource.getConnection();
        connection.setSchema(tenantIdentifier.toString());
        return connection;
    }

    @Override
    public void releaseConnection(Object tenantIdentifier, Connection connection) throws SQLException {
        connection.setSchema("PUBLIC");
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType){
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, this);
    }
}
