package com.np.todos.repository;

import com.np.todos.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project save(Project Project);
    Optional<Project> findById(Long idProject);
    List<Project> findAllByUserId(Long idUser);
}
