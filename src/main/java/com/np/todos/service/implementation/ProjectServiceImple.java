package com.np.todos.service.implementation;

import com.np.todos.dto.DTOProject;
import com.np.todos.entity.Project;
import com.np.todos.entity.User;
import com.np.todos.exception.GeralNoResultException;
import com.np.todos.repository.ProjectRepository;
import com.np.todos.repository.UserRepository;
import com.np.todos.service.ProjectService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ProjectServiceImple implements ProjectService {

    private final ProjectRepository repository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    @Override
    public Project save(DTOProject dtoProject) {
        Project project = mapper.map(dtoProject, Project.class);

        Optional<User> optionalUser = userRepository.findById(dtoProject.getUser_id());
        User user = optionalUser.orElseThrow(() -> new GeralNoResultException("usuário não encotrado para o projeto"));

        project.setUser(user);
        project.setCreated(LocalDateTime.now());
        project.setUpdated(LocalDateTime.now());
        project.setTasks(new ArrayList<>());
        project.setDescription("");

        return repository.save(project);
    }
    @Override
    public Optional<Project> findById(Long idProject) {
        return repository.findById(idProject);
    }
    @Override
    public List<Project> findAllByIdUser(Long idUser) {
        return repository.findAllByUserId(idUser);
    }

    @Override
    public Project update(DTOProject dtoProject, Long idProject) {
        Optional<Project> optionalProject = repository.findById(idProject);
        Project project = optionalProject.orElseThrow(() -> new GeralNoResultException("Projecto não encontrado para atualizar"));

        Project updatedProject = mapper.map(dtoProject, Project.class);
        project.setName(updatedProject.getName());
        project.setUpdated(LocalDateTime.now());

        return repository.save(project);
    }
}
