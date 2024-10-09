package com.example.multi_tenant_schema.resolver;

import com.example.multi_tenant_schema.context.TenantContext;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {

    String DEFAULT_TENANT_ID = "PUBLIC";

    @Override
    public String resolveCurrentTenantIdentifier(){
        return Objects.requireNonNullElse(TenantContext.getCurrentTenant(), DEFAULT_TENANT_ID);
    }

    @Override
    public boolean validateExistingCurrentSessions(){
        return false;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties){
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, this);
    }
}
