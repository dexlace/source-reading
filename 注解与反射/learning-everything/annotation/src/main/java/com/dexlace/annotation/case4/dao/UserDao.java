package com.dexlace.annotation.case4.dao;

import com.dexlace.annotation.case4.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public User findUserById(Integer id) {
        System.out.println("查询id为[" + id + "]的用户");
        if(id > 10) {
            return null;
        }
        User user = new User(id, "user-" + id);
        System.out.println("返回的用户为[" + user.toString() + "]");
        return user;

    }
}

