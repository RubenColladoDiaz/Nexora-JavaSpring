package com.nexora.api.controllers;

import com.nexora.api.entities.User;
import com.nexora.api.services.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping("/register")
    public void register(@RequestBody String name, @RequestBody String email, @RequestBody String password){
        User newUser = new User();
        String hashedPassword = userService.hashPassword(password);

        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(hashedPassword);

        userService.save(newUser);
    }
}
