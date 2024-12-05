package com.education.nawamaga.service.impl;

import com.education.nawamaga.dto.ResponseDto;
import com.education.nawamaga.dto.UserDto;
import com.education.nawamaga.entity.User;
import com.education.nawamaga.repo.UserRepo;
import com.education.nawamaga.service.UserService;
import com.education.nawamaga.util.JwtAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    private final JwtAuthentication jwtAuthentication;
    @Autowired
    public UserServiceImpl(UserRepo userRepo, JwtAuthentication jwtAuthentication) {
        this.userRepo = userRepo;
        this.jwtAuthentication = jwtAuthentication;
    }

    @Override
    public ResponseDto RegisterUser(UserDto userDto) {

        String encodedPassword = Base64.getEncoder().encodeToString(userDto.getPassword().getBytes());

        User save = userRepo.save(new User(null, userDto.getUserName(), encodedPassword, userDto.getRole(),null));

        return new ResponseDto(save.getUserName(),save.getRole(),"registered");

    }

    @Override
    public ResponseDto LoginUser(UserDto userDto) {

        User byUserName = userRepo.findByUserName(userDto.getUserName());
        String encodedPassword = Base64.getEncoder().encodeToString(userDto.getPassword().getBytes());

        if (byUserName != null) {
            String token = jwtAuthentication.generateJwtAuthentication(byUserName);
            if (byUserName.getPassword().equals(encodedPassword)) {
                return new ResponseDto(byUserName.getUserName(),"logged in",token,byUserName.getRole());
            }

        }
        return new ResponseDto(userDto.getUserName(),"not logged in");

    }
}
