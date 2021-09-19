package advancedJava.linkedHashMap;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {

    public static void main(String[] args) {
        // the third argument in the linked hash map decides, how the ordering should be done
        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap(4, 75f, true);

        hashMap.put("Krishna", 1);
        hashMap.put("Rajesh", 2);
        hashMap.put("Mike", 3);
        hashMap.put("Ram", 4);

//        hashMap.get("Krishna");
        hashMap.get("Rajesh");
//        hashMap.get("Krishna");
        System.out.println(hashMap);
    }
}
