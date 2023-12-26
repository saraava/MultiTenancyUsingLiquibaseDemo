package com.example.liquibasedemo.Repository.tenant;

import com.example.liquibasedemo.Entity.tenant.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface taskRepository extends JpaRepository<Task,Long> {
}
