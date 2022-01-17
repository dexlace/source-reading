package com.dexlace.annotation.case6.entity;

import com.dexlace.annotation.case6.annotation.FirstConstraint;
import lombok.Data;


@Data
public class User{
    private String userName;
    @FirstConstraint(minLength=10,maxLength=20)
    private String userEmail;
}