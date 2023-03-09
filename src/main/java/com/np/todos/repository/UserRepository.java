package com.np.todos.repository;

import com.np.todos.dto.DTOUser;
import com.np.todos.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmailAndPassword(String email, String  password);
}
