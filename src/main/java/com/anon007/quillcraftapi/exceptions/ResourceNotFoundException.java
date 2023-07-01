package com.anon007.quillcraftapi.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    final String resourceName, fieldName;
    UUID fieldValue;
    int fieldValueInt;

    public ResourceNotFoundException(String resourceName, String fieldName, UUID fieldValue) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValueInt) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValueInt));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueInt = fieldValueInt;
    }
}
