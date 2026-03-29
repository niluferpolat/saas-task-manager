package com.nilufer.saas_task_manager_api.service;

import com.nilufer.saas_task_manager_api.dto.ProjectRequestDto;
import com.nilufer.saas_task_manager_api.dto.ProjectResponse;
import com.nilufer.saas_task_manager_api.entity.Project;
import com.nilufer.saas_task_manager_api.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectResponse> getProjects() {
        return projectRepository.findAll().stream().map(ProjectResponse::of).toList();
    }

    public ProjectResponse getProjectById(Long id){
        Project project = projectRepository.findById(id).orElseThrow();
        return ProjectResponse.of(project);
    }

    public void deleteProject(Long id){
        if(!projectRepository.existsById(id)){
            throw new RuntimeException("Project not found with id:"+ id);
        }
        projectRepository.deleteById(id);
    }

    public ProjectResponse updateProject(Long id, ProjectRequestDto projectRequestDto){
        Project project = projectRepository.findById(id).orElseThrow();
        project.setProgress(projectRequestDto.getProgress());
        project.setDueDate(projectRequestDto.getDueDate());
        project.setPhase(projectRequestDto.getPhase());
        project.setName(projectRequestDto.getName());
        project.setDescription(projectRequestDto.getDescription());
        project.setProjectStatus(projectRequestDto.getStatus());

        Project updatedProject = projectRepository.save(project);
        return ProjectResponse.of(updatedProject);

    }

    @Transactional
    public ProjectResponse createProject(ProjectRequestDto dto) {
        Project project = mapToEntity(dto);
        Project saved = projectRepository.save(project);
        return ProjectResponse.of(saved);
    }

    private Project mapToEntity(ProjectRequestDto dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setProjectStatus(dto.getStatus());
        project.setPhase(dto.getPhase());
        project.setDueDate(dto.getDueDate());
        project.setTasks(new ArrayList<>());
        project.setProgress(Optional.ofNullable(dto.getProgress()).orElse(0));
        return project;
    }
}
