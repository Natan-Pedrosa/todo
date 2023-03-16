package com.np.todos.service.implementation;

import com.np.todos.dto.DTOUser;
import com.np.todos.entity.User;
import com.np.todos.repository.UserRepository;
import com.np.todos.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImple implements UserService {
    private final UserRepository repository;
    private ModelMapper mapper;

    @Override
    public User save(DTOUser dtoUser){
        User user = mapper.map(dtoUser, User.class);
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        user.setProjects(new ArrayList<>());

        return repository.save(user);
    }
    @Override
    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

}