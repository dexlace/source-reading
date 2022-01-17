package com.dexlace.annotation.case2;

public class PasswordUtils {
    @UseCase(id = 47, description = "password must contain one number")
    public boolean validatePassword(String password){
        return true;
    }
    @UseCase(id = 48)
    public String encryptPassword(String password){
        return "encryptPassword()";
    }
    @UseCase(id = 49, description = "new password can't equal previously used ones")
    public boolean checkouForNewPassword(){
        return false;
    }
}

