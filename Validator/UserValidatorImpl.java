package com.dy.controller.validator;

import com.dy.model.entities.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 10/10/2017.
 */
public class UserValidatorImpl implements UserValidator {

    @Override
    public Map<String, String> validate(User user) {
        Map<String, String> errorMap = new HashMap<>();
        //validateLogin(user.getLogin(), errorMap);
        //validatePassword(user.getPassword(), errorMap);
        validateEmail(user.getEmail(), errorMap);
        return errorMap;
    }

    private void validateLogin(String login, Map<String, String> errorMap){
        if(login == null) {
            errorMap.put("login", "login == null");
        }else if(login.length()<3) {
            errorMap.put("login", "login.lenght<3");
        }else if(login.length()>10){
            errorMap.put("login", "login.lenght>10");
        }
    }

    private void validatePassword(String password, Map<String, String> errorMap){
        if(password == null) {
            errorMap.put("login", "login == null");
        }else if(password.length()<3) {
            errorMap.put("login", "login.lenght<3");
        }else if(password.length()>10){
            errorMap.put("login", "login.lenght>10");
        }
    }

    private void validateEmail(String email, Map<String, String> errorMap){
        if(email == null) {
            errorMap.put("login", "login == null");
        }else if(email.length()<3) {
            errorMap.put("login", "login.lenght<3");
        }else if(email.length()>10){
            errorMap.put("login", "login.lenght>10");
        }
    }


}
