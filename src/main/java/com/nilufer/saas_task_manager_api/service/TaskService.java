package com.nilufer.saas_task_manager_api.service;

import com.nilufer.saas_task_manager_api.dto.TaskRequestDto;
import com.nilufer.saas_task_manager_api.entity.Project;
import com.nilufer.saas_task_manager_api.entity.Task;
import com.nilufer.saas_task_manager_api.repository.ProjectRepository;
import com.nilufer.saas_task_manager_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
private final TaskRepository taskRepository;
private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public List<Task> getTaskByProject(Long projectId){
    return taskRepository.findAllByProjectId(projectId);
}

public Task createTask(TaskRequestDto taskRequestDto){
    Project project = projectRepository.findById(taskRequestDto.getProjectId()).orElseThrow();
    Task task = new Task();
    task.setDescription(task.getDescription());
    task.setTitle(task.getTitle());
    task.setProject(project);
    return taskRepository.save(task);
}
}
