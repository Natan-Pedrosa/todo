package com.np.todos.service;

import com.np.todos.dto.DTOUser;
import com.np.todos.entity.User;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserService {
    User save(@NonNull DTOUser dtoUser);
    Optional<User> findById(@NonNull Long id);

}
