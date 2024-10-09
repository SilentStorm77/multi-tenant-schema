package com.example.multi_tenant_schema.resolver;

import org.springframework.lang.NonNull;

@FunctionalInterface
public interface TenantResolver<T> {

    String resolveTenantId(@NonNull T request);
}
