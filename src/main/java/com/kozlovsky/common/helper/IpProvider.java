package com.kozlovsky.common.helper;

import org.springframework.stereotype.Component;

/**
 * Created by anton on 24.03.17.
 */
@Component
public class IpProvider {

    private String ip;

    public  String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
