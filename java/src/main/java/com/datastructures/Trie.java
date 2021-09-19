package com.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Trie {

    public static TrieNode root = new TrieNode();

    public static void main(String[] args) {

//        add("cat");
        add("krishna");
        add("kri");
//        add("kumar");
        System.out.println(findCount(root,"kri"));
//        System.out.println(find(root,"ku",0));
    }

    public static void add(String str) {
        if(!root.map.containsKey(str.charAt(0))) {
            TrieNode node = new TrieNode();
            root.map.put(str.charAt(0),node);
        }
        root = add(str,0,root);

    }

    private static boolean find(TrieNode trieNode,String str,int length) {
        if(trieNode != null && trieNode.map.size() == 0 && trieNode.isPresent) {
            System.out.println(trieNode.isPresent);
            return true;
        } else if(trieNode != null && trieNode.map.size() != 0 && !trieNode.isPresent
                    && length < str.length()) {
            System.out.println(str.charAt(length) + "  ::  ");
            return find(trieNode.map.get(str.charAt(length)), str, (length + 1));
        }
        return false;

    }

    private static int findCount(TrieNode trieNode,String str) {
        int counter = 0;
        TrieNode prev = null;
        if(trieNode != null) {
            int i = 0;
            while(trieNode.map.size() > 0) {
                if(trieNode.map.containsKey(str.charAt(i))) {
                    prev = trieNode;
                    trieNode = trieNode.map.get(str.charAt(i));
                    i++;
                } else {
                    break;
                }

            }
        }
        System.out.println(trieNode.isPresent);
        if(trieNode.isPresent) {
            System.out.println(findPostFix(prev));
        }
        return counter;

    }

    public static int findPostFix(TrieNode trieNode) {
        if(trieNode == null) {
            return 0;
        }

        for(Character ch : trieNode.map.entrySet().stream().map(v -> v.getKey()).collect(Collectors.toList())) {
            return  0 + findPostFix(trieNode.map.get(ch));
        }
        return 1;
    }

    public static TrieNode add( String str,int length, TrieNode node ) {
        if((str.length()-1) == length) {
            TrieNode n = new TrieNode();
            node.map.put(str.charAt(length),n);
            n.isPresent = true;
            return node ;
        }
        if(node.map.containsKey(str.charAt(length))) {
            TrieNode trieNode = node.map.get(str.charAt(length));
            TrieNode newNode = new TrieNode();
            trieNode.map.put(str.charAt(++length),newNode);
             add(str,length,trieNode);
        }
        return node;
    }




    public static class TrieNode {
        Map<Character,TrieNode> map = new HashMap<>();
        boolean isPresent = false;

    }

}
