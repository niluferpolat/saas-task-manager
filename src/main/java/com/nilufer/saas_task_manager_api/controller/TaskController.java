package com.nilufer.saas_task_manager_api.controller;

import com.nilufer.saas_task_manager_api.dto.TaskRequestDto;
import com.nilufer.saas_task_manager_api.entity.Task;
import com.nilufer.saas_task_manager_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/createTask")
    public Task createTask(@RequestBody TaskRequestDto taskRequestDto){
        return  taskService.createTask(taskRequestDto);
    }

    @GetMapping("/tasks/project/{id}")
    public List<Task> getTasksByProject(@PathVariable Long id){
        return taskService.getTaskByProject(id);
    }
}
