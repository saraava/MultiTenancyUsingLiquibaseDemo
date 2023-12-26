package com.example.liquibasedemo.Entity.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Component
public class AddCompanyDTO {


    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    private String company_Address;
    private String description;
}
