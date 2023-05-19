package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.mapper.MapperController;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
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
    private final MapperController<User, UserDTO> mapperController;


    @Override
    public UserDTO getUserById(Integer id) {
        User user = userService.getUserById(id);
        return mapperController.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getUsers();
        return users.stream()
                .map(mapperController::toDTO)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public Integer createUser(UserDTO userDTO) {
        User user;
        /*TODO: Aqui Validadar contraseña y validador de username*/
        user = User.builder()
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .isActive(true)
                .role(null)
                .build();

        return userService.createUser(user);
    }

    @Override
    public void updateUser(Integer id, UserDTO userDTO) {
        User user;

        user = User.builder()
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .role(null)/*TODO: ojota*/
                .build();

        userService.updateUser(id, user);
    }

    @Override
    public void deleteUserById(Integer id) {
        /*TODO: Permisos para eliminar*/
        userService.deleteUserById(id);
    }
}
