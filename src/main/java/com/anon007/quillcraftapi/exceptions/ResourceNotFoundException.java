package com.anon007.quillcraftapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    final String resourceName, fieldName;
    final String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
