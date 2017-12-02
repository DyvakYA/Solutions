package com.dy.controller.validator;

import com.dy.model.entities.User;

import java.util.Map;

/**
 * Created by User on 10/10/2017.
 */
public interface UserValidator extends Validator<User> {

    @Override
    Map<String, String> validate(User entity);
}
