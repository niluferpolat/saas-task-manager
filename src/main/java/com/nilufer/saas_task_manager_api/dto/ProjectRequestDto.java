package com.nilufer.saas_task_manager_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectRequestDto {
    private String name;
    private String description;
    private String phase;
    private Integer progress;
    private ProjectStatus status;
    private LocalDate dueDate;
}
