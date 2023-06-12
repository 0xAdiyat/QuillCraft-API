package com.anon007.quillcraftapi.payloads;

public class APIResponse {
    private String message;
    private boolean success;

    public APIResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
