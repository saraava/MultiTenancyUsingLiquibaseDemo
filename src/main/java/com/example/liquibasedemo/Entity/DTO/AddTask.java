package com.example.liquibasedemo.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddTask {

    public String name;
    public String description;
    public String assigned_to;

}
