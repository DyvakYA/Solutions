package com.dy.model.dao.exceptions;

import com.dy.controller.exception.ApplicationException;

/**
 * Created by User on 7/22/2017.
 */
public class DaoException extends ApplicationException {

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause){
        super(message, cause);
    }
}
