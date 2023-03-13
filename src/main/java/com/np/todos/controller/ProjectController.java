package com.np.todos.controller;

import com.np.todos.dto.DTOProject;
import com.np.todos.entity.Project;
import com.np.todos.exception.GeralNoResultException;
import com.np.todos.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/project/")
public class ProjectController {

    private final ProjectService service;

    @PostMapping
    public ResponseEntity<Project> save(@NonNull @RequestBody DTOProject dtoProject){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(service.save(dtoProject));
    }
    @GetMapping("{id}")
    public ResponseEntity<Project> findById(@NonNull @PathVariable(name = "id") Long idProject){
        return ResponseEntity.ok(service.findById(idProject).orElseThrow(() -> new GeralNoResultException("Projeto não encotrado")));
    }
    @GetMapping("all/{id}")
    public List<Project> findAll(@NonNull @PathVariable(name = "id") Long idUser){
        return service.findAllByIdUser(idUser);
    }

}
