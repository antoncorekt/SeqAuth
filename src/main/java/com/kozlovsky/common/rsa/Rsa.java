package com.kozlovsky.common.rsa;

import com.kozlovsky.common.controller.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Created by anton on 25.03.17.
 */

public class Rsa {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    public Rsa() {
        LOGGER.info("constructor rsa");
    }

   // public static final BigInteger maxRand = new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
    public static final BigInteger maxRand = new BigInteger(512,new Random());

    private BigInteger publicKey;
    private BigInteger privateKey;
    private BigInteger fi;
    private BigInteger n;

    private BigInteger a;
    int count=0;
    public BigInteger generatePrimeNumbers(){
        a = rndBigInt(maxRand);




        if (!a.isProbablePrime(1)){
            count++;
           return generatePrimeNumbers();
        }
        else {
            LOGGER.info("COUNTER {}", count);

            return a;
        }

    }

    public void refresh(){
        publicKey = privateKey = null;
    }

    private BigInteger findFI(BigInteger p, BigInteger q){
        n = p.multiply(q);
        LOGGER.info("N = p*q = {}", n);

        return p.subtract(ONE).multiply(q.subtract(ONE));
    }

    private BigInteger getX(BigInteger fi){
        BigInteger x = rndBigInt(maxRand);
        if (x.compareTo(new BigInteger("1"))==1 && x.compareTo(fi)==-1){
            if(x.gcd(fi).equals(ONE)){
                return x;
            }

        }
        return getX(fi);
    }
    private BigInteger getY(BigInteger publicKey, BigInteger fi){
        BigInteger x = exGCD.calculate(publicKey, fi).x;

        if (x.compareTo(ZERO)==-1){
            x = x.add(fi);
        }

        //LOGGER.info("x in Diafant equals {}", x);
        return x;
    }

    public BigInteger getPublicKey(){
        if (publicKey!=null) return publicKey;

        BigInteger p,q;
        do{
            p = generatePrimeNumbers();
            q = generatePrimeNumbers();
        }while (p.equals(q));

        LOGGER.info("Generating primer nums: {} and : {}", p,q);

        fi = findFI(p,q);

        LOGGER.info("FI = {}", fi);

        publicKey = getX(fi);

        LOGGER.info("Public key: {} ", publicKey);

        return publicKey ;
    }

    public BigInteger getPrivateKey(){
        if (privateKey!=null) return privateKey;

        privateKey = getY(publicKey,fi);
        LOGGER.info("Private key: {} ", privateKey);
        return privateKey;
    }


    public static BigInteger rndBigInt(BigInteger max) {
        Random rnd = new Random();
        do {
            BigInteger i = new BigInteger(max.bitLength(), rnd);
            if (i.compareTo(max) <= 0)
                return i;
        } while (true);
    }


    public ArrayList<String> encrypt(String str, BigInteger x, BigInteger y){
        ArrayList<String> k = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            k.add(new BigInteger(String.valueOf(str.codePointAt(i))).modPow(x,y).toString());
        }

        return k;
    }

    public String decrypt(ArrayList<String> str, BigInteger publicKey){
        BigInteger privatKey = getPrivateKey();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.size(); i++) {
            res.append(Character.toString((char)Integer.parseInt(new BigInteger(String.valueOf(str.get(i))).modPow(privatKey,n).toString())));
        }

        return res.toString();
    }

    public String arrayToStr(ArrayList<String> arr){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:arr){
            stringBuilder.append(s).append("O");
        }
        return stringBuilder.toString();
    }

    public ArrayList<String> strToArray(String str){
        return new ArrayList<>(Arrays.asList(str.split("O")));
    }

    public void setPublicKey(BigInteger publicKey) {
        this.publicKey = publicKey;
    }

    public void setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
    }

    public BigInteger getFi() {
        return fi;
    }

    public void setFi(BigInteger fi) {
        this.fi = fi;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }
}