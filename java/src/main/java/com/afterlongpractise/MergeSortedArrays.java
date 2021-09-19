package com.afterlongpractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

    public static void main(String[] args) {

        PriorityQueue<Item> ps = new PriorityQueue<Item>((a,b) -> a.element.compareTo(b.element));
        List<Integer> ls1= List.of(1, 5, 9, 21);
        List<Integer> ls2= List.of(-1, 0);
        List<Integer> ls3= List.of(-124, 81, 121);
        List<Integer> ls4= List.of(3, 6, 12, 20, 150);
        List<List<Integer>> list = new ArrayList<>();
        list.add(ls1);
        list.add(ls2);
        list.add(ls3);
        list.add(ls4);
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < list.size(); i++) {
            ps.add(new Item(list.get(i).get(0),1,i));
        }
        while(!ps.isEmpty()) {
            Item item = ps.remove();
            result.add(item.element);
            List<Integer> currentList = list.get(item.list);
            if(item.elementIDx < currentList.size()) {
                int pos = item.elementIDx;
                ps.add(new Item(currentList.get(pos), pos+1, item.list));
            }
            System.out.println(ps);
            System.out.println(result);
        }


    }

    static class Item {
        Integer elementIDx;
        Integer element;
        Integer list;

        Item(Integer element, Integer elementIDx, Integer list) {
            this.element = element;
            this.elementIDx = elementIDx;
            this.list = list;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "elementIDx=" + elementIDx +
                    ", element=" + element +
                    ", list=" + list +
                    '}';
        }
    }
}
