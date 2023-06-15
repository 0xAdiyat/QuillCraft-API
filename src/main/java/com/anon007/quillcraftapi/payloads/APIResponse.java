package com.anon007.quillcraftapi.payloads;

import java.util.Map;

public class APIResponse {

    private final String message;

    private final boolean isSuccess;
    private final int status;
    private final Map<String, Object> responseMap;


    public APIResponse(String message, boolean isSuccess, int status) {

        this.message = message;
        this.isSuccess = isSuccess;
        this.status = status;

        this.responseMap = Map.of(
                "message", message,
                "success", isSuccess,
                "status", status
        );

    }

    public Map<String, Object> getResponseMap() {
        return responseMap;
    }


}
