package com.sda.restdemo.dto;

import com.sda.restdemo.enums.Role;
import lombok.Data;

@Data
public class UserDTO {

    private Role role;
    private String username;
    private String password;

}
