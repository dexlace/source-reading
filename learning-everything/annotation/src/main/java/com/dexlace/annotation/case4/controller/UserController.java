package com.dexlace.annotation.case4.controller;

import com.dexlace.annotation.case4.annotation.MyLog;
import com.dexlace.annotation.case4.entity.User;
import com.dexlace.annotation.case4.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MyLog("这是自定义的日志内容")
    @RequestMapping("user/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }
}
