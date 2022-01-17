package com.dexlace.annotation.case6.controller;


import com.dexlace.annotation.case6.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidTest {

    @RequestMapping(value = "valid")
    public User hello(@Validated User dao){

        return dao;
    }
}
