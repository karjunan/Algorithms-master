package com.java8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteArrayExample {

    public static void main(String[] args) {

        File file = new File("test.txt");

        try {
            FileInputStream fs = new FileInputStream(file);
            System.out.println((char)fs.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
