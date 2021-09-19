package secondChance;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(5);
        objects.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(7);
        list1.add(-1);
        objects.add(list1);
        objects.add(3);
        List<Object> list2 = new ArrayList<>();
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(-13);
        list3.add(8);
        list2.add(list3);
        list2.add(4);
        objects.add(list2);
        System.out.println(objects);
        int result = sum(objects,1);

    }

    public static int sum(List<Object> objects, int depth) {
        int sum = 0;
       // System.out.println(sum);
        for(Object objects1: objects) {
            if(objects1 instanceof ArrayList) {
                sum += sum((List<Object>)objects1,depth+1);
                System.out.println("After recurssion => "+ sum);
            } else {
                sum = sum+(Integer)objects1;
            }
            System.out.println("After normal Loops  =>  " + sum);
        }
        System.out.println("Depth level => " + depth);
        return sum * depth;
    }
}
