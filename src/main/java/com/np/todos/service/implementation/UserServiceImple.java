package com.np.todos.service.implementation;

import com.np.todos.dto.DTOUser;
import com.np.todos.entity.User;
import com.np.todos.exception.GeralNoResultException;
import com.np.todos.repository.UserRepository;
import com.np.todos.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImple implements UserService {
    private final UserRepository repository;
    private ModelMapper mapper;
    public User save(DTOUser dtoUser){
        User user = mapper.map(dtoUser, User.class);
        return repository.save(user);
    }
    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new GeralNoResultException( id, "Usuário não encontrado"));
    }
    public User findByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password).orElseThrow(() -> new GeralNoResultException("", "Email or password estão errado"));
    }
}