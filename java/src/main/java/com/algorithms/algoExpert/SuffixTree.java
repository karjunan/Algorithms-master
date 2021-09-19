package com.algorithms.algoExpert;

import java.util.HashMap;
import java.util.Map;

public class SuffixTree {

    static TrieNode root = new TrieNode();
    static char endSymbol = '*';

    public static void main(String[] args) {

        String str = "I am krishna";
        String search = "I";
        populateSuffixTree(str);
        boolean result = search(search);
        System.out.println("Result -> " + result);
    }

    public static void populateSuffixTree(String str) {
        TrieNode temp = root;

        for( int i = 0 ; i < str.length(); i++) {
            TrieNode node = root;
            for(int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    TrieNode empty = new TrieNode();
                    node.children.put(ch,empty);
                    node = node.children.get(ch);
                }
            }
            node.children.put(endSymbol,null);
        }
//        TrieNode n = root.children.get('t').children.get('t');
//        print(n);
    }

    public static void print( TrieNode node) {

        if(node == null || node.children.containsKey(endSymbol)) {
            return;
        } else {
            for(Map.Entry<Character,TrieNode> n :   node.children.entrySet())      {
                System.out.println(n.getKey());
                print(node.children.get(n.getKey()));
                System.out.println("");
            }
        }

        // System.out.println("");
    }

    public static boolean search(String str) {
        TrieNode node= root;
        for( int i = 0 ; i < str.length();i++) {
            if(node.children.containsKey(str.charAt(i))) {
                node = node.children.get(str.charAt(i));
            } else {
                return false;
            }
        }
        System.out.println(node.children);
        if(node.children.containsKey(endSymbol)) {
            return true;
        }
        return false;
    }
    static class TrieNode {
        HashMap<Character,TrieNode> children = new HashMap<>();
    }
}
