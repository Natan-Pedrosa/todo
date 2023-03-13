package com.np.todos.service;

import com.np.todos.dto.DTOProject;
import com.np.todos.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

     Project save(DTOProject dtoProject);
    Optional<Project> findById(Long idProject);
    List<Project> findAllByIdUser(Long idUser);
}
