package com.np.todos.exception;

import jakarta.persistence.NoResultException;

public class GeralNoResultException extends NoResultException {
    public GeralNoResultException(String message) {
        super(message);
    }
}
