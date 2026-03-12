package com.nilufer.saas_task_manager_api.service;

import com.nilufer.saas_task_manager_api.dto.ProjectRequestDto;
import com.nilufer.saas_task_manager_api.entity.Project;
import com.nilufer.saas_task_manager_api.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Project createProject(ProjectRequestDto projectRequestDto){
        Project project = new Project();
        project.setDescription(projectRequestDto.getDescription());
        project.setName(projectRequestDto.getName());
        projectRepository.save(project);
        return project;
    }
}
