package com.example.multi_tenant_schema.interceptor;

import com.example.multi_tenant_schema.context.TenantContext;
import com.example.multi_tenant_schema.resolver.HttpHeaderTenantResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TenantInterceptor implements HandlerInterceptor {
    private final HttpHeaderTenantResolver tenantResolver;

    public TenantInterceptor(HttpHeaderTenantResolver resolver){
        this.tenantResolver = resolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String tenantName = tenantResolver.resolveTenantId(request);
        TenantContext.setCurrentTenant(tenantName);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        clear();
    }

    private void clear(){
        TenantContext.clear();
    }
}
