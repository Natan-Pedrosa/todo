package com.np.todos.service.implementation;

import com.np.todos.dto.DTOTask;
import com.np.todos.entity.Project;
import com.np.todos.entity.Task;
import com.np.todos.exception.GeralNoResultException;
import com.np.todos.repository.ProjectRepository;
import com.np.todos.repository.TaskRepository;
import com.np.todos.service.TaskService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskServiceImple implements TaskService {

    private final TaskRepository repository;
    private final ProjectRepository projectRepository;
    private final ModelMapper mapper;
    @Override
    public Task save(DTOTask dtoTask) {
        Task task = mapper.map(dtoTask, Task.class);

        Optional<Project> optionalProject = projectRepository.findById(dtoTask.getProject_id());
        Project project = optionalProject.orElseThrow(() -> new GeralNoResultException("Projeto não encontrado para esta tarefa"));

        task.setCreated(LocalDateTime.now());
        task.setUpdated(LocalDateTime.now());
        task.setProject(project);

        return repository.save(task);
    }
    @Override
    public Optional<Task> findById(Long idTask) {

        return repository.findById(idTask);
    }
    @Override
    public List<Task> findAllByProjectId(Long idProject) {

        return repository.findAllByProjectId(idProject);
    }

    @Override
    public Task update(DTOTask dtoTask, Long idTask) {
        Optional<Task> optionalTask = repository.findById(idTask);
        Task task = optionalTask.orElseThrow(() -> new GeralNoResultException("Tarefa não encontrada"));

        Task updatedTask = updateTask(dtoTask, task);

        return repository.save(updatedTask);
    }

    private Task updateTask(DTOTask dtoTask, Task task){
        Task updatedTask;
        updatedTask = mapper.map(dtoTask, Task.class);

        if(task.getProject().getId() != dtoTask.getProject_id()){
            Optional<Project> optional = projectRepository.findById(dtoTask.getProject_id());
            Project project = optional.orElseThrow(() -> new GeralNoResultException("Projeto não ao tentar atualizar tarefa"));

            updatedTask.setProject(project);
        }else {
            updatedTask.setProject(task.getProject());
        }

        updatedTask.setId(task.getId());
        updatedTask.setCreated(task.getCreated());
        updatedTask.setUpdated(LocalDateTime.now());
        
        return updatedTask;
    }
}
