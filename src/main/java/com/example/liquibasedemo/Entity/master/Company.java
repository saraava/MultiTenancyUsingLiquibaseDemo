package com.example.liquibasedemo.Entity.master;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", columnDefinition = "varchar(255)",nullable = false,unique = true)
    private String name;

    @Column(name = "company_address", columnDefinition = "varchar(1024)")
    private String company_Address;

    @Column(name = "description", columnDefinition = "varchar(1024)", nullable = true)
    private String description;

    @Column(name = "schema_name", columnDefinition = "varchar(1024)", nullable = false)
    private String schema_name;

    @CreationTimestamp
    @Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;


}
