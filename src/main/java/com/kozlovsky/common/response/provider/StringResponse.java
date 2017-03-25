package com.kozlovsky.common.response.provider;

/**
 * Created by anton on 25.03.17.
 */
public class StringResponse  implements ResponseData{

    private String response;


    public StringResponse(String s) {
        this.response = s;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
