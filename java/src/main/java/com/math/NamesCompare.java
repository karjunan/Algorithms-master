package com.math;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NamesCompare {

    public static void main(String[] args) throws Exception {

        String file = getFile(".");

        String[] parsedString = file.split(",");


        int[] pos = new int[128];
//        ROCHEL [61][249856][4096]
        System.out.println("Hello " + ('R' - 64));
        System.out.println("Hello " + ('O' - 64));
        System.out.println("Hello " + ('C' - 64));
        System.out.println("Hello " + ('H' - 64));
        System.out.println("Hello " + ('E' - 64));
        System.out.println("Hello " + ('Z' - 64));

        // 18 + 15 + 3+8+5+12

        Comparator<String> comparator = Comparator.naturalOrder();
//        Comparator<String> intComparator = Comparator.comparingInt(String::length);
//        Comparator<String> finalCompartor = comparator.thenComparing(intComparator);

        List<String> list = Stream.of(parsedString).map(v -> {
            String str = v.replace("\"", "");
            return str;
        }).sorted(comparator)
                .collect(toList());
        Map<String, List<Character>> map = Stream.of(parsedString).map(v -> {
            String str = v.replace("\"", "");
            return str;
        })
                .collect(Collectors.toMap(k -> k,
                        s -> s.chars().mapToObj(v -> Character.valueOf((char) v)).collect(Collectors.toList())));
//        System.out.println(map);

//        System.out.println(list);

        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(map.get(list.get(i)));
            long charSize = (list.get(i).chars().mapToLong(v -> v - 64).sum());
            long val = charSize * (i + 1);
            sum = sum + val;
            System.out.println(list.get(i) + "[" + charSize + "][" + val + "]" + "[" + (i + 1) + "]");
        }
        System.out.println(sum);

    }

    public static String getFile(String str) throws Exception {
        Path path = Paths.get(str, "names.txt");
        StringBuffer buffer = new StringBuffer();
        if (Files.exists(path)) {
            FileReader reader = new FileReader(path.toFile());
            int data = reader.read();
            while (data != -1) {
//                System.out.println((char)data);
                buffer.append((char) data);
                data = reader.read();
            }
        }
//        System.out.println(buffer.toString());
        return buffer.toString();
    }
}
