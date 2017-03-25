package com.kozlovsky.common.response.provider;

/**
 * Created by anton on 25.03.17.
 */
public class PublicKeyResponse implements ResponseData {

    private String publicKey;

    private String n;

    public PublicKeyResponse(String publicKey, String n) {
        this.publicKey = publicKey;
        this.n = n;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }
}
