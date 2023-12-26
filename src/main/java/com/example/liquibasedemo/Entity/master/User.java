package com.example.liquibasedemo.Entity.master;

import com.example.liquibasedemo.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "User_Name", columnDefinition = "varchar(255)",nullable = false)
    private String name;

    @Column(name = "User_Email", columnDefinition = "varchar(255)",unique = true,nullable = false)
    private String email;

    @Column(name = "User_Password", columnDefinition = "varchar(255)",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
