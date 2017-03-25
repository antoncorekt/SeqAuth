package com.kozlovsky;

import com.kozlovsky.common.rsa.Rsa;
import org.junit.Test;

import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by anton on 25.03.17.
 */
public class TestRSA {

    public static final String TEXT = "Hello word!!";

    @Test
    public void test() throws NoSuchAlgorithmException {
        Rsa rsa = new Rsa();

        BigInteger publicKey = rsa.getPublicKey();
        BigInteger privateKey  = rsa.getPrivateKey();

        BigInteger n = rsa.getN();

        String s = rsa.arrayToStr(rsa.encrypt(TEXT,publicKey,n));

        System.out.println(TEXT);
        System.out.println("Encrypt : " + s);

        String d = rsa.decrypt(rsa.strToArray(s),n);
        System.out.println("Decrypt : " + d);


    }
}
