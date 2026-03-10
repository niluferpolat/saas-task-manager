package com.nilufer.saas_task_manager_api.service;

import com.nilufer.saas_task_manager_api.dto.RegisterDto;
import com.nilufer.saas_task_manager_api.entity.User;
import com.nilufer.saas_task_manager_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String register(RegisterDto registerDto){
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setName(registerDto.getName());
        user.setPassword(registerDto.getPassword());

        userRepository.save(user);
        return "başarılı";
    }
}
