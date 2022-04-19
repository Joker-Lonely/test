package com.example.sdust_confession_wall.dto;
/*
 * @author Joker
 * @data 2022/4/17 17:56
 */

import lombok.Data;

@Data
public class RegisterDTO {
    private Long id;
    private String username;
    private String password;
    private String matchingpassword;
    private String email;
}
