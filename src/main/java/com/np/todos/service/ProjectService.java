package com.np.todos.service;

import com.np.todos.dto.DTOProject;
import com.np.todos.entity.Project;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project save(@NonNull DTOProject dtoProject);
    Optional<Project> findById(@NonNull Long idProject);
    List<Project> findAllByIdUser(@NonNull Long idUser);

    Project update(@NonNull DTOProject dtoProject,@NonNull Long idProject);
}
