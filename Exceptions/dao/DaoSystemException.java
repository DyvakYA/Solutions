package com.dy.model.dao.exceptions;

/**
 * Created by User on 7/22/2017.
 */
public class DaoSystemException extends DaoException {

    public DaoSystemException(String message) {
        super(message);
    }

    public DaoSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
