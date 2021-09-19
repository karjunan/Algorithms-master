package advancedJava.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

    public static void main(String[] args) {
        Integer[] in = new Integer[]{1,2,3,4,5,6,7,8,9};
        String[] str = new String[] {"a","b","c"};
        Character [] ch = new Character[] {'e','f','g'};

        List<Integer> integers = convertToListWithGenerics(in, new ArrayList<>());
        List<Boolean> strings = convertToList(str, new ArrayList<>());
        List<String> characters = convertToList(ch, new ArrayList<>());

       // System.out.println(integers.get(0));
       // System.out.println(strings.get(0));
        System.out.println(integers.get(0));

    }

    public static List  convertToList(Object[] array, List<Object> list) {
        for(Object obj: array) {
            list.add(obj);
        }

        return list;
    }

    public static <T> List<T> convertToListWithGenerics(T[] t, List<T> list) {
        for(T obj : t) {
            list.add(obj);
        }

        return list;
    }
}
