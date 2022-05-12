package com.sda.restdemo.services;

import com.sda.restdemo.dto.UserDTO;
import com.sda.restdemo.exceptions.ResourceNotFoundException;
import com.sda.restdemo.model.User;
import com.sda.restdemo.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return findByUsername(username);
    }

    public User addUser(UserDTO userDTO) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());
        return usersRepository.save(user);
    }

    public void deleteUser(String username) {
//        User user = findByUsername(username);
//        usersRepository.deleteById(user.getId());
        usersRepository.deleteByUsername(username);
    }

    private User findByUsername(String username) {
        return usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
