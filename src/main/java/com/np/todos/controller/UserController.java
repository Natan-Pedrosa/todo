package com.np.todos.controller;

import com.np.todos.dto.DTOUser;
import com.np.todos.entity.User;
import com.np.todos.exception.GeralNoResultException;
import com.np.todos.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user/")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<User> create(@NonNull @RequestBody DTOUser dtoUser){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(service.save(dtoUser));
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id") Long id){

        return ResponseEntity.ok(service.findById(id).orElseThrow(() -> new GeralNoResultException("Não encontrado usuário")));
    }

}