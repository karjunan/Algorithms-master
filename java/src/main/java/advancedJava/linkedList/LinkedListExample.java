package advancedJava.linkedList;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add(1,"c");
        System.out.println(linkedList);

        linkedList.remove("b");

        System.out.println(linkedList);
    }
}
