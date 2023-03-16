package com.np.todos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tarefa")
public class Task extends BaseObject {

    private String name;
    private String description;
    @Column(name = "is_important")
    private Boolean isImportant;
    @Column(name = "is_completed")
    private Boolean isCompleted;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "expect_finalized")
    private LocalDate expectFinalized;
    private LocalDate finalized;

    @JsonBackReference
    public Project getProject() {
        return project;
    }
}
