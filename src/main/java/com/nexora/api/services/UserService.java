package com.nexora.api.services;

import com.nexora.api.core.dtos.LoginRequest;
import com.nexora.api.core.dtos.RegisterRequest;
import com.nexora.api.core.dtos.UserResponse;
import com.nexora.api.entities.User;
import com.nexora.api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean checkPassword(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }

    @Transactional
    public UserResponse register(RegisterRequest request) {
        String email = request.email().trim().toLowerCase();

        if (userRepository.existsByEmail(email))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");

        User user = new User();
        user.setName(request.name().trim());
        user.setEmail(email);
        user.setPassword(hashPassword(request.password()));

        User saved = userRepository.save(user);
        return new UserResponse(saved.getId(), saved.getName(), saved.getEmail());
    }

    @Transactional
    public UserResponse login(LoginRequest request){
        if(!userRepository.existsByName(request.name()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");

        User loggedUser = userRepository.findByName(request.name());
        if(!checkPassword(request.password(), loggedUser.getPassword()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Password is not correct");

        return new UserResponse(loggedUser.getId(), loggedUser.getName(), loggedUser.getEmail());
    }
}
