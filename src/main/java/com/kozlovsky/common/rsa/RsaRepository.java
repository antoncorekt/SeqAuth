package com.kozlovsky.common.rsa;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by anton on 25.03.17.
 */
@Component
public class RsaRepository {

    private Map<String,Rsa> rsas = new HashMap<>();

    public Rsa addRsa(String name){
        rsas.put(name, new Rsa());
        return getRsa(name);
    }

    public void refresh(String name){
        rsas.get(name).refresh();
    }

    public boolean isHaveRsa(String name){
        return rsas.containsKey(name);
    }

    public Rsa getRsa(String name){
        return rsas.get(name);
    }
}
