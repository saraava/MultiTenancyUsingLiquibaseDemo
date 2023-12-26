package com.example.liquibasedemo.Entity.tenant;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", columnDefinition = "varchar(255)",nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "varchar(1024)",nullable = true)
    private String description;

    @Column(name = "assigned_to", columnDefinition = "varchar(255)",nullable = false)
    private String assigned_to;

    @Column(name = "created_by", columnDefinition = "varchar(255)",nullable = false)
    private String created_by;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime createdAt;


    @Column(name = "updated_by", columnDefinition = "varchar(255)",nullable = true)
    private String updated_by;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    //This column will get executed before the entity is updated.
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
