package com.education.nawamaga.controller;

import com.education.nawamaga.dto.ResponseDto;
import com.education.nawamaga.dto.UserDto;
import com.education.nawamaga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

   final UserService userService;
   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> Register(@RequestBody UserDto user) {
        ResponseDto responseDto = userService.RegisterUser(user);
       return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }



    @PostMapping("/login")
    public ResponseEntity<ResponseDto> Login(@RequestBody UserDto user) {
       ResponseDto responseDto = userService.LoginUser(user);
       return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


}
