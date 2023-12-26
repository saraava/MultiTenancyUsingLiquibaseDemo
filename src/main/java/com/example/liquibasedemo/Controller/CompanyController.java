package com.example.liquibasedemo.Controller;
import com.example.liquibasedemo.Entity.DTO.AddCompanyDTO;
import com.example.liquibasedemo.Entity.master.Company;
import com.example.liquibasedemo.Repository.master.companyRepository;
import com.example.liquibasedemo.Service.TenantService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@RestController
@RequestMapping("/api/master")
public class CompanyController {

    private final companyRepository companyRepository;
    private TenantService tenantService;

    public CompanyController(com.example.liquibasedemo.Repository.master.companyRepository companyRepository, TenantService tenantService) {
        this.companyRepository = companyRepository;
        this.tenantService = tenantService;
    }



//    @GetMapping("/getcompany")
//    public Optional<Company> getcompany(Long id)
//    {
//        return companyRepository.findById(id);
//    }

    @PostMapping("/addcompany")
    public ResponseEntity<String> addCompany(@RequestBody AddCompanyDTO companyDTO)
    {
        try {

            String schemaName =companyDTO.getName().replaceAll("\\s", "").toUpperCase();

            Company company = new Company();
            company.setName(companyDTO.getName());
            company.setCompany_Address(companyDTO.getCompany_Address());
            company.setDescription(companyDTO.getDescription());
            company.setSchema_name(schemaName);


            companyRepository.save(company);
            tenantService.initializeSchema(company);
            return ResponseEntity.ok("Entity created successfully");
        } catch (NullPointerException e) {
            // Handle unique constraint violation
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nullable constraint violated");
        } catch (ConstraintViolationException e) {
            // Handle nullable constraint violation
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unique constraint violated");
        }
        catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error "+ e.getMessage());
        }

    }

}
