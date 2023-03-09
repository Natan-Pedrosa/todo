package com.np.todos.exception;

import jakarta.persistence.NoResultException;

public class GeralNoResultException extends NoResultException {
    public GeralNoResultException(Object value, String message) {
        super(message + " " + value);
    }
}
