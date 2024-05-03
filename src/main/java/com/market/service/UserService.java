package com.market.service;

import com.market.dto.user.CreateUserDTO;
import com.market.dto.user.UpdateUserDTO;
import com.market.dto.user.UserDTO;

import java.util.List;

/**
 * @author Азизбек
 * @project Market
 * @date 03.05.2024
 * @time 16:55
 */
public interface UserService {
    void createUser(CreateUserDTO createUserDTO);

    UserDTO updateUserById(Long id, UpdateUserDTO updateUserDTO);

    UserDTO getUserById(Long id);

    UserDTO deleteUserById(Long id);

    List<UserDTO> getUserList();

    void signIn(String username, String password);
}