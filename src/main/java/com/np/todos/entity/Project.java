package com.np.todos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "projeto")
public class Project extends Object{

    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
    @JsonManagedReference
    public List<Task> getTasks() {
        return tasks;
    }
    @JsonBackReference
    public User getUser() {
        return user;
    }
}
