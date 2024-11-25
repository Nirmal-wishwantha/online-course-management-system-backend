package com.education.nawamaga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String userName;
    private String password;
    private String role;

    public UserDto(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }




}
