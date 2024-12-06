package com.education.nawamaga.dto;

import com.education.nawamaga.status.userRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private Integer id;
    private String userName;
    private userRole role;
    private String token;
    private String massage;
    private String identity;

    public ResponseDto(String userName, String massage, String identity) {
        this.userName = userName;
        this.massage = massage;
        this.identity = identity;
    }

    public ResponseDto(Integer id, String userName, userRole role, String token, String massage) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.token = token;
        this.massage = massage;
    }

    public ResponseDto(Integer id, String userName, userRole role, String massage) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.massage = massage;
    }

    public ResponseDto(String userName, String massage) {
        this.userName = userName;
        this.massage = massage;
    }
}
