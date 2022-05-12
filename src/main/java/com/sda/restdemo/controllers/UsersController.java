package com.sda.restdemo.controllers;

import com.sda.restdemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.sda.restdemo.dto.UserDTO;
import com.sda.restdemo.services.UsersDetailsServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersDetailsServiceImpl usersDetailsService;

    @PostMapping("/add")
    public User addUser(@RequestBody UserDTO userDTO) {
        return usersDetailsService.addUser(userDTO);
    }


    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        usersDetailsService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
