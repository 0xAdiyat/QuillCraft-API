package com.anon007.quillcraftapi.payloads;

public class APIResponse {

    private String message;

    private boolean isSuccess;

    private int
            status;

    public APIResponse() {

    }

    public APIResponse(String message, boolean isSuccess, int status) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
