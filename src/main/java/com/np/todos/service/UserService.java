package com.np.todos.service;

import com.np.todos.dto.DTOUser;
import com.np.todos.entity.User;

public interface UserService {
    User save(DTOUser dtoUser);
    User findById(Long id);
    User findByEmailAndPassword(String email, String password);
}
