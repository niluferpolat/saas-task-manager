package com.nilufer.saas_task_manager_api.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String name;
    private String password;
    private String email;
}
