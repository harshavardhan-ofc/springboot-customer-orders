// exception/ResourceNotFoundException.java
package com.project.customer.orders.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
