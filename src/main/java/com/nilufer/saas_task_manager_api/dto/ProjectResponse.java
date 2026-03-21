package com.nilufer.saas_task_manager_api.dto;

import com.nilufer.saas_task_manager_api.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class ProjectResponse {
    private Long id;
    private String name;
    private String description;
    private ProjectStatus status;
    private Integer progress;
    private String phase;
    private LocalDate dueDate;
    private List<TaskResponse> tasks;

    public static ProjectResponse of(Project project) {
        List<TaskResponse> taskResponses = project.getTasks().stream().map(TaskResponse::of).toList();

        return new ProjectResponse(project.getId(), project.getName(), project.getDescription(),
                project.getProjectStatus(), project.getProgress(), project.getPhase(), project.getDueDate(), taskResponses);
    }
}