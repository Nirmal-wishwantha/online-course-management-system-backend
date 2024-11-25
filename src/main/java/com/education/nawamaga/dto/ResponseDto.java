package com.education.nawamaga.dto;

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

    public ResponseDto(String userName, String massage) {
        this.userName = userName;
        this.massage = massage;
    }
}
