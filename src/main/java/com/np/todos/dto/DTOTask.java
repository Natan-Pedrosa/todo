package com.np.todos.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DTOTask {

    private String name;
    private String description;
    private Long project_id;
    private LocalDate expectFinalized;
    private Boolean isCompleted;
    private Boolean isImportant;

}
