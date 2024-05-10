package org.example.iocexam.controller;

import org.example.iocexam.domain.User;
import org.example.iocexam.service.UserService;

public class UserController {
    private UserService userService;

    public void joinUser(){
        //실제 동작할 때는 사용자로 부터 정보를 받아온다.
        User user = new User();
        user.setName("kang");
        user.setEmail("carami@gmail.com");
        user.setPassword("1234");

        userService.joinUser(user);
    }
}
