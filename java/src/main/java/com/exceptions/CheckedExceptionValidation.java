package com.exceptions;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionValidation {

    public static void main(String[] args)  {
        File file = new File("D:\\esteelauder");
        try {
            recursiveFileFind(file);
        } catch (IOException e) {
            System.out.println("No File Found ");
        } catch (NullPointerException ex) {
            System.out.println("Wrong file path");
        }

    }

    public static void recursiveFileFind(File file) throws IOException {
        for(File f: file.listFiles()) {
            if(f.isDirectory()) {
                System.out.println("Directory is ---------" + f.getName());
                recursiveFileFind(f);
            }  else {
                System.out.println(f.getName());
            }

       }

    }


}
