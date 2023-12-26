package com.example.liquibasedemo.Controller;

import com.example.liquibasedemo.Entity.DTO.AddTask;
import com.example.liquibasedemo.Entity.tenant.Task;
import com.example.liquibasedemo.Repository.tenant.taskRepository;
import com.example.liquibasedemo.Util.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/tenant")
public class TaskController {

    private final com.example.liquibasedemo.Repository.tenant.taskRepository taskRepository;

    @Autowired
    public TaskController(taskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/addtask")
    public Task addTask(@RequestBody AddTask addTask,@RequestHeader("X-Tenant-ID") String tenantIdentifier)
    {
        Task task = new Task();
        task.setName(addTask.getName());
        task.setDescription(addTask.getDescription());
        task.setAssigned_to(addTask.getAssigned_to());
        task.setCreated_by("Admin");
        task.setUpdated_by("Admin");
//        task.setCreatedAt();

        TenantContext.setCurrentTenant(tenantIdentifier);
        System.out.println("getCurrentTenat: "+TenantContext.getCurrentTenant());
        return taskRepository.save(task);



    }
}
