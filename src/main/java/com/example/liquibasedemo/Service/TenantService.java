package com.example.liquibasedemo.Service;

import com.example.liquibasedemo.Config.TenantConnectionProvider;
import com.example.liquibasedemo.Config.TenantIdentifierResolver;
import com.example.liquibasedemo.Entity.master.Company;
import com.example.liquibasedemo.Repository.master.companyRepository;
import org.springframework.stereotype.Component;

@Component
public class TenantService {

    private companyRepository companyRepository;
    private TenantIdentifierResolver tenantIdentifierResolver;
    private TenantConnectionProvider tenantConnectionProvider;

    public TenantService(com.example.liquibasedemo.Repository.master.companyRepository companyRepository, TenantIdentifierResolver tenantIdentifierResolver, TenantConnectionProvider tenantConnectionProvider) {
        this.companyRepository = companyRepository;
        this.tenantIdentifierResolver = tenantIdentifierResolver;
        this.tenantConnectionProvider = tenantConnectionProvider;
    }

    public void initializeSchema(Company company) {

//        String CompanyName = company.getName();
        tenantConnectionProvider.singleTenantCreation(company);
    }






}
