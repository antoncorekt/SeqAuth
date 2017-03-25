package com.kozlovsky.common.response.provider;

/**
 * Created by anton on 25.03.17.
 */
public class ErrorResponse implements ResponseData {

    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
