package com.dy.controller.validator;

import java.util.Map;

/**
 * Created by User on 10/10/2017.
 */
public interface Validator<T> {

    Map<String, String> validate(T entity);
}
