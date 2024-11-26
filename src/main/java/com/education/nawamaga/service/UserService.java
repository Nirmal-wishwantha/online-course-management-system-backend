package com.education.nawamaga.service;

import com.education.nawamaga.dto.ResponseDto;
import com.education.nawamaga.dto.UserDto;

public interface UserService {

    ResponseDto RegisterUser(UserDto userDto);

    ResponseDto LoginUser(UserDto userDto);




}
