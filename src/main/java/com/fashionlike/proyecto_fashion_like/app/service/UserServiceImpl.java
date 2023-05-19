package com.fashionlike.proyecto_fashion_like.app.service;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Integer createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(Integer id, User user) {
        User userToEdit = userRepository.findById(id);
        if (userToEdit == null) {
            userRepository.save(user);
        } else {
            userToEdit.setName(user.getName());
            userToEdit.setPassword(userToEdit.getPassword());
            userToEdit.setUsername(user.getUsername());
            userToEdit.setRole(user.getRole());
            userRepository.save(userToEdit);
        }

    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
