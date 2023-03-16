package com.np.todos.controller;

import com.np.todos.dto.DTOTask;
import com.np.todos.entity.Task;
import com.np.todos.exception.GeralNoResultException;
import com.np.todos.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tarefa/")
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<Task> save(@NonNull @RequestBody DTOTask dtoTask){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(service.save(dtoTask));
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> findById(@NonNull @PathVariable("id") Long idTask){
        return ResponseEntity.ok(service.findById(idTask).orElseThrow(() -> new GeralNoResultException("Tarefa não encontrada")));
    }

    @GetMapping("all/{id}")
    public List<Task> findAllByProjectId(@NonNull @PathVariable("id") Long idProject){
        return service.findAllByProjectId(idProject);
    }
    @PutMapping("{id}")
    public ResponseEntity<Task> update(@NonNull @RequestBody DTOTask dtoTask, @NonNull @PathVariable("id") Long idTask){

        return ResponseEntity.ok(service.update(dtoTask, idTask));
    }

}
