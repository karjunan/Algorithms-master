package com.math;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class LongSum {


    public static void main(String[] args) throws IOException {
        List<String> list = read();
        Optional<BigDecimal> sum = list.stream().map(v -> {
            BigDecimal l = new BigDecimal(v);
//            System.out.println(l);
            return l;
        }).reduce((k, v) -> k.add(v));

        System.out.println(sum.get());
        for (int i = 0; i < 10; i++) {
            System.out.print(sum.get().toString().charAt(i));
        }
    }


    public static void findSum(BigDecimal bigDecimal) {

        System.out.println(bigDecimal.toString());

    }


    public static List<String> read() throws IOException {
        Path path = Paths.get("src", "main", "resources", "number.txt");
        List<String> list = Files.readAllLines(path);
        System.out.println(list);
        return list;
    }
}
