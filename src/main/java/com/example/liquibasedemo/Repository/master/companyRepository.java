package com.example.liquibasedemo.Repository.master;

import com.example.liquibasedemo.Entity.master.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface companyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findById(Long Id);
//    <S extends Company> Company save(Company company);
}
