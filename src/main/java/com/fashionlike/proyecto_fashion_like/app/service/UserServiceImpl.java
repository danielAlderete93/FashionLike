package com.fashionlike.proyecto_fashion_like.app.service;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.service.RoleService;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import com.fashionlike.proyecto_fashion_like.domain.validators.authentication.AuthenticationValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.authentication.PasswordValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final AuthenticationValidator authenticationValidator;
    private final PasswordValidator passwordValidator;


    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Integer create(User user) throws DomainException {
        Role savedRole;
        Integer idRole;

        authenticationValidator.validate(user);

        idRole = roleService.create(user.getRole());
        savedRole = roleService.getById(idRole);

        user.setRole(savedRole);

        return userRepository.save(user);
    }

    @Override
    public void update(Integer id, User user) throws DomainException {
        User userToEdit = userRepository.findById(id).orElse(null);

        if (userToEdit == null) {
            create(user);
        } else {
            passwordValidator.validate(user);
            userToEdit.setName(user.getName());
            userToEdit.setPassword(user.getPassword());
            userToEdit.setIsActive(user.getIsActive());
            userRepository.save(userToEdit);
        }

    }

    @Override
    public Boolean deleteById(Integer id) {
        return userRepository.deleteById(id);
    }
}
