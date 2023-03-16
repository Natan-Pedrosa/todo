package com.np.todos.repository;

import com.np.todos.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task save(Task task);
    Optional<Task> findById(Long idTask);
    List<Task> findAllByProjectId(Long idProject);

}
