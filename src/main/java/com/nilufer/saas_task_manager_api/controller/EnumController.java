package com.nilufer.saas_task_manager_api.controller;

import com.nilufer.saas_task_manager_api.dto.ProjectStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/enums")
public class EnumController {

    @GetMapping("/project-status")
    public List<Map<String, String>> getProjectStatus() {
        return Arrays.stream(ProjectStatus.values())
                .map(status -> Map.of(
                        "value", status.getValue(),
                        "label", status.getLabel()
                ))
                .toList();
    }
}
