package com.np.todos.service;

import com.np.todos.dto.DTOUser;
import com.np.todos.entity.User;

import java.util.Optional;

public interface UserService {
    User save(DTOUser dtoUser);
    Optional<User> findById(Long id);

}
