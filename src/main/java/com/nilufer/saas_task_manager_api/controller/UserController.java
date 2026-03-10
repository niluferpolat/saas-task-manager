package com.nilufer.saas_task_manager_api.controller;

import com.nilufer.saas_task_manager_api.dto.RegisterDto;
import com.nilufer.saas_task_manager_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterDto registerDto){
        return userService.register(registerDto);
    }
}
