package com.nilufer.saas_task_manager_api.dto;

public enum Priority {
    HIGH(3),MEDIUM(2),LOW(1);
    private int value;
    Priority(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
