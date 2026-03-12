package com.nilufer.saas_task_manager_api.repository;

import com.nilufer.saas_task_manager_api.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
