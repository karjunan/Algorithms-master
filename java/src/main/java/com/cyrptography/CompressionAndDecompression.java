package com.cyrptography;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CompressionAndDecompression {

    public static void main(String[] args) throws  Exception{

        String str = "krishna";
        String compressedString = compress(str);
//        decompress(compressedString);
    }

    private static String compress(String str) {

        BigInteger bigInteger = BigInteger.valueOf(1);
        BigInteger bigInteger1 = BigInteger.valueOf(10);
        bigInteger = bigInteger.multiply(bigInteger1);
        System.out.println(bigInteger.toString());
        return null;

    }

}
