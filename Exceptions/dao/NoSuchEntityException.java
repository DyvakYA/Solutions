package com.dy.model.dao.exceptions;

/**
 * Created by User on 7/22/2017.
 */
public class NoSuchEntityException extends DaoBusinessException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
