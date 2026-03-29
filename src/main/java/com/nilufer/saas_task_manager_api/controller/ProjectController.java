package com.nilufer.saas_task_manager_api.controller;

import com.nilufer.saas_task_manager_api.dto.ProjectRequestDto;
import com.nilufer.saas_task_manager_api.dto.ProjectResponse;
import com.nilufer.saas_task_manager_api.entity.Project;
import com.nilufer.saas_task_manager_api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ProjectResponse createProject(@RequestBody ProjectRequestDto projectRequestDto){
        return projectService.createProject(projectRequestDto);
    }

    @GetMapping
    public List<ProjectResponse> getProjects(){
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponse getProjectById(@PathVariable("id") Long id){
        return projectService.getProjectById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(
            @PathVariable Long id,
            @RequestBody ProjectRequestDto project
    ) {
        ProjectResponse response = projectService.updateProject(id, project);
        return ResponseEntity.ok(response);
    }
}
