package com.nilufer.saas_task_manager_api.dto;

public enum ProjectStatus {
    ON_TRACK("On Track"),
    DONE("Done"),
    PRIORITY("Priority");

    private final String label;

    ProjectStatus(String label) {
        this.label = label;
    }

    public String getValue() {
        return name();
    }

    public String getLabel() {
        return label;
    }
}