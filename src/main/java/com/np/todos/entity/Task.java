package com.np.todos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tarefa")
public class Task extends Object{

    private String name;
    private String description;
    private boolean important;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
    private LocalDateTime expectFinalized;
    private LocalDateTime finalized;

    @JsonBackReference
    public Project getProject() {
        return project;
    }
}
