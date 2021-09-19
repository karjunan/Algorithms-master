package com.algorithms.arrayproblems;

import java.security.*;

public class RsaCrypto {

    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();
            System.out.println(publicKey.getEncoded());
            System.out.println(privateKey.getEncoded());
            String str = "helo.krishna";
            String[] split = str.split("\\." );
            System.out.println(split[0]);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
