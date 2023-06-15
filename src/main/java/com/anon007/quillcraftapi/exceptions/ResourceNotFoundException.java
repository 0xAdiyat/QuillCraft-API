package com.anon007.quillcraftapi.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    final String resourceName, fieldName;
    final UUID fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, UUID fieldValue) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
