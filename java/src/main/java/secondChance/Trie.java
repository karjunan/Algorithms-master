package secondChance;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    static TrieNode root = new TrieNode();
    public static void main(String[] args) {
        String str = "babc";
        insert(str);
        String result = contains("babc");
        String result1 = contains("c");
        String result2 = contains("abc");
        String result3 = contains("ba");

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);


    }

    public static void insert(String str) {

        for(int i = 0; i < str.length(); i++) {
            TrieNode current = root;
            StringBuffer buffer = new StringBuffer();
            for(int j = i; j < str.length(); j++) {
                buffer.append(str.charAt(j));
                if(!current.children.containsKey(str.charAt(j))) {
                    current.children.put(str.charAt(j), new TrieNode());
                }
                current = current.children.get(str.charAt(j));
            }
            current.children.put('*', null);
            current.name = buffer.toString();
        }
    }

    public static String contains(String str) {
        TrieNode current = root;
        for(Character ch: str.toCharArray()) {
            if(current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else {
                return "String match not found";
            }
        }
        if(current.children.containsKey('*') && current.name.equals(str) ) {
            return "String Match found " + str;
        }
        return "String match not found";
    }

    static class TrieNode {
        String name;
        Map<Character, TrieNode> children = new HashMap<>();

    }
}
