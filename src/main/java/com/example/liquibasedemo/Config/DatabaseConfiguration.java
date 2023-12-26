package com.example.liquibasedemo.Config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(JpaProperties.class)
@EnableJpaRepositories(entityManagerFactoryRef = "masterEntityManagerFactory", transactionManagerRef = "masterTransactionManager", basePackages = {
        "com.example.liquibasedemo.Repository.master" })
public class DatabaseConfiguration {

    private final TableExistenceChecker tableExistenceChecker;

    public DatabaseConfiguration(TableExistenceChecker tableExistenceChecker) {
        this.tableExistenceChecker = tableExistenceChecker;
    }


    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        System.out.println("do they exists:"+tableExistenceChecker.areTablesExist());
        if(!tableExistenceChecker.areTablesExist())
        {
          liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
        }
        else
        {
            liquibase.setChangeLog("classpath:db/changelog/db.changelog-alter.xml");
            System.out.println("Tables already exists");
        }
        return liquibase;
    }

    @Primary
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(DataSource dataSource){

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.liquibasedemo.Entity.master");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return em;
    }

    @Bean(name = "masterTransactionManager")
    public JpaTransactionManager masterTransactionManager(
            @Qualifier("masterEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }








}
