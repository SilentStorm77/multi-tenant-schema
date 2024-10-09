package com.example.multi_tenant_schema.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class HttpHeaderTenantResolver implements TenantResolver<HttpServletRequest>{

    private final String TENANT_HEADER = "Tenant-Name";

    @Override
    public String resolveTenantId(HttpServletRequest request){
        return request.getHeader(TENANT_HEADER);
    }
}
