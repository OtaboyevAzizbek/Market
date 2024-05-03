package com.market.service.impl;

import com.market.dto.user.CreateUserDTO;
import com.market.dto.user.UpdateUserDTO;
import com.market.dto.user.UserDTO;
import com.market.entity.User;
import com.market.mapper.UserMapper;
import com.market.repository.UserRepository;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Азизбек
 * @project Market
 * @date 03.05.2024
 * @time 16:56
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public void createUser(CreateUserDTO createUserDTO) {
        createUserDTO.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setPassword(createUserDTO.getPassword());
        user.setRole(createUserDTO.getRole());
        userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO updateUserById(Long id, UpdateUserDTO updateUserDTO) {
        updateUserDTO.setPassword(passwordEncoder.encode(updateUserDTO.getPassword()));
        User user = userRepository.getReferenceById(id);
        user.setUsername(updateUserDTO.getUsername());
        user.setPassword(updateUserDTO.getPassword());
        user.setRole(updateUserDTO.getRole());
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.toDTO(userRepository.getReferenceById(id));
    }

    @Override
    public UserDTO deleteUserById(Long id) {
        User user = userRepository.getReferenceById(id);
        userRepository.deleteById(id);
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getUserList() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    @Override
    public void signIn(String username, String password) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
