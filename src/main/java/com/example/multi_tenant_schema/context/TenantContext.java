package com.example.multi_tenant_schema.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenantContext {

    private static final Logger log = LoggerFactory.getLogger(TenantContext.class);

    private static final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    public static String getCurrentTenant(){
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }
    public static void clear(){
        currentTenant.remove();
    }
}
