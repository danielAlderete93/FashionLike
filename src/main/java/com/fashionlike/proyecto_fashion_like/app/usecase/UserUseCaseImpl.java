package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.RoleDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.mapper.MapperController;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserUseCaseImpl implements UserUseCase {
    private final UserService userService;
    private final MapperController<Role, RoleDTO> roleMapperController;
    private final MapperController<User, UserDTO> userMapperController;


    @Override
    public UserDTO getUserById(Integer id) {
        User user = userService.getUserById(id);
        return userMapperController.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getUsers();
        return users.stream()
                .map(userMapperController::toDTO)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public Integer createUser(UserDTO userDTO) throws DomainException {
        User user;
        Role role;
        /*TODO: VALIDACION DEL ROLE ACA*/
        role = roleMapperController.toDomain(userDTO.getRole());

        user = User.builder()
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .isActive(true)
                .role(role)
                .build();

        return userService.createUser(user);
    }

    @Override
    public void updateUser(Integer id, UserDTO userDTO) throws DomainException {
        User user;
        Role role;
        role = roleMapperController.toDomain(userDTO.getRole());
        user = User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .isActive(userDTO.getIsActive())
                .role(role)
                .build();

        userService.updateUser(id, user);
    }

    @Override
    public void deleteUserById(Integer id) {
        /*TODO: Permisos para eliminar*/
        userService.deleteUserById(id);
    }
}
