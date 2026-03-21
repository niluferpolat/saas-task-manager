package com.nilufer.saas_task_manager_api.dto;

import com.nilufer.saas_task_manager_api.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TaskResponse {
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;

    public static TaskResponse of(Task task) {
        return new TaskResponse(task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority());
    }
}
