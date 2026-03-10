package com.nilufer.saas_task_manager_api.repository;

import com.nilufer.saas_task_manager_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
