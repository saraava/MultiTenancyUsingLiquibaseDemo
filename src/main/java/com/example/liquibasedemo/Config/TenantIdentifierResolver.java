package com.example.liquibasedemo.Config;

import com.example.liquibasedemo.Util.TenantContext;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    static final String DEFAULT_TENANT = "default";


    @Override
    public String resolveCurrentTenantIdentifier() {
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        if (requestAttributes instanceof ServletRequestAttributes) {
//            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
//
//            // Get the tenant ID from the 'X-Tenant-ID' header (adjust the header name as needed)
//            String tenantId = request.getHeader("X-Tenant-ID");
//            System.out.println("Tenant ID: "+tenantId);
//
//            if (StringUtils.isNotBlank(tenantId)) {
//                TenantContext.setCurrentTenant(tenantId);
//                return tenantId;
//            }
//        }

        return TenantContext.getCurrentTenant() != null
                ? TenantContext.getCurrentTenant()
                : DEFAULT_TENANT;

//        TenantContext.setCurrentTenant(DEFAULT_TENANT);
//        return DEFAULT_TENANT;


    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
