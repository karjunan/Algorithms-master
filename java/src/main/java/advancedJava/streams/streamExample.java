package advancedJava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class streamExample {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);

        List<Integer> resultList = list.stream().filter(v -> v.equals(1)).collect(Collectors.toList());

        System.out.println(resultList);
    }
}
