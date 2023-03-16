package com.np.todos.service;

import com.np.todos.dto.DTOTask;
import com.np.todos.entity.Task;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task save(@NonNull DTOTask dtoTask);
    Optional<Task> findById(@NonNull Long idTask);
    List<Task> findAllByProjectId(@NonNull Long idProject);
    Task update(@NonNull DTOTask dtoTask,@NonNull Long idTask);

}
