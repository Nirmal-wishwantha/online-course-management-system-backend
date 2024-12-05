package com.education.nawamaga.dto;

import com.education.nawamaga.status.userRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String userName;
    private String massage;
    private String token;
    private userRole role;

    public ResponseDto(String userName, String massage, String token) {
        this.userName = userName;
        this.massage = massage;
        this.token = token;
    }

    public ResponseDto(String userName, userRole role, String massage) {
        this.userName = userName;
        this.role = role;
        this.massage = massage;

    }

    public ResponseDto(String userName, String massage) {
        this.userName = userName;
        this.massage = massage;
    }
}
