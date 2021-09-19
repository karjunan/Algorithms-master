package com.algorithms.arrayproblems;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

    public static void main(String[] args) {
        try {
            MessageDigest ms =  MessageDigest.getInstance("SHA-256");
            String str = "Krisnna";

            System.out.println(ms.digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
