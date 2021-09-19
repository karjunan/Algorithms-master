package com.google;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static TrieNode root = new TrieNode(false);
    static char endSymbol = '*';

    public static void main(String[] args) {

        String str = "abc";
        String str1 = "abgl";
        String str2 = "cdf";
        populateSuffixTrieFrom(str);
        populateSuffixTrieFrom(str1);
        populateSuffixTrieFrom(str2);
        boolean bool = contains("c");
        System.out.println("Word contained in the string => " + bool);
    }

    public static void populateSuffixTrieFrom(String str) {
        TrieNode reference = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!reference.children.containsKey(ch)) {
                reference.children.remove('*');
                TrieNode node = new TrieNode(false);
                node.children.put('*', node);
                reference.children.put(ch, node);
                reference = reference.children.get(ch);
            } else {
                reference = reference.children.get(ch);
            }
        }
    }

    public static boolean contains(String str) {
        TrieNode reference = root;
        for(char ch: str.toCharArray()) {
            if(reference.children.containsKey(ch)) {
                reference = reference.children.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean endOfWord;

        TrieNode(boolean bool) {
            this.endOfWord = bool;
        }
    }
}
