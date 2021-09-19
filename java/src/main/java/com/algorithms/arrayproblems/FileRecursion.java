package com.algorithms.arrayproblems;

import java.io.File;

public class FileRecursion {

    public static void main(String[] args) {

        String str = "c:";
        File file = new File(str);
        findFiles(file);
    }


    public static void findFiles(File file) {
        if(file.isDirectory() ) {
            File [] files = file.listFiles();
            for(int i= 0; i < files.length-1; i++) {
                findFiles(files[i]);
            }
        } else {

            System.out.println(file.getName());
            return;
        }


    }
}

