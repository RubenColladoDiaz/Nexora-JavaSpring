package com.nexora.api.services;

import com.nexora.api.entities.User;
import com.nexora.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User save(User product){
        return userRepository.save(product);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
