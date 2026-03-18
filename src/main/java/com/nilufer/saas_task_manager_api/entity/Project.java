package com.nilufer.saas_task_manager_api.entity;

import com.nilufer.saas_task_manager_api.dto.ProjectStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "project")
@Data
public class Project extends BaseEntity{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String name;
private String description;

private Integer progress;
private String phase;
private LocalDate dueDate;

@Enumerated(EnumType.STRING)
private ProjectStatus projectStatus;

@ManyToOne
@JoinColumn(name = "user_id")
private User user;

@OneToMany(mappedBy = "project",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
private List<Task> tasks;
}
