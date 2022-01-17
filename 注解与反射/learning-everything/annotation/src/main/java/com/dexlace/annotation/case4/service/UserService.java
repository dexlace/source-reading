package com.dexlace.annotation.case4.service;

import com.dexlace.annotation.case4.dao.UserDao;
import com.dexlace.annotation.case4.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }
}


