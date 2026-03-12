package com.nilufer.saas_task_manager_api.dto;

import lombok.Data;

@Data
public class TaskRequestDto {
    private String title;
    private String description;
    private Long projectId;
}
