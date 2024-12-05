package com.education.nawamaga.dto;

import com.education.nawamaga.entity.User;
import com.education.nawamaga.status.userRole;
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
    private userRole role;
    private String token;





}
