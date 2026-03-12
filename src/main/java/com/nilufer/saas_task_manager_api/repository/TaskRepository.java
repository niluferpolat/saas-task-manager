package com.nilufer.saas_task_manager_api.repository;

import com.nilufer.saas_task_manager_api.entity.Project;
import com.nilufer.saas_task_manager_api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
     List<Task> findAllByProjectId(Long id);
}
