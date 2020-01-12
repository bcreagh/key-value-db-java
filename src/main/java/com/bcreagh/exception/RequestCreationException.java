package com.bcreagh.exception;

/**
 * Represents a failure while creating a request
 */
public class RequestCreationException extends RuntimeException {

    private static final long serialVersionUID = 4316604883073518349L;

    public RequestCreationException(String message) {
        super(message);
    }
}
