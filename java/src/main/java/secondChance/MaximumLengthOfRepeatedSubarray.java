package secondChance;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthOfRepeatedSubarray {


    public static void main(String[] args) {

        int [] nums1 = new int[] {1,2,3,2,1};
        int [] nums2 = new int[] {3,2,1,4,7};

        MaximumLengthOfRepeatedSubarray mx = new MaximumLengthOfRepeatedSubarray();
        System.out.println("DP => " + mx.findLength(nums1,nums2));
        System.out.println("Trie based Solution => " + mx.trieSolution(nums1,nums2));
        System.out.println("Brute force => " + mx.bruteForce(nums1,nums2));
    }

    public int findLength(int[] nums1, int[] nums2) {

        int [][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Integer.max(dp[i][j], max);
                }
            }
        }
        return max;

    }

    public int trieSolution(int [] nums1, int [] nums2) {
        if(nums1.length < nums2.length) {
            int [] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        Trie trie = new Trie();
        trie.buildSuffixTrie(nums1);
        trie.view(trie.root);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums2.length; i++) {
            TrieNode current = trie.root;
            int count = 0;
            for(int j = i; j < nums2.length; j++) {
                // System.out.println(nums2[j] + " == " + current.map);
                if(current.map.containsKey(nums2[j])) {
                    current = current.map.get(nums2[j]);
                    count++;
                } else {
                    break;
                }
            }
            max = Integer.max(count,max);
            //System.out.println("Max count is => " + max);
        }


        return max;
    }

    public class TrieNode {
        Map<Integer, TrieNode> map = new HashMap<>();
        String name = "";
    }

    public class Trie {
        TrieNode root = new TrieNode();

        public  void buildSuffixTrie(int [] nums) {


            for(int i = 0; i < nums.length; i++) {
                // StringBuffer buffer = new StringBuffer();
                TrieNode current = root;
                for(int j = i; j < nums.length; j++) {
                    if(!current.map.containsKey(nums[j])) {
                        current.map.put(nums[j], new TrieNode());
                    }
                    // buffer.append(nums[j]);
                    current = current.map.get(nums[j]);
                }
                // current.name = buffer.toString();
            }

        }

        public void view (TrieNode root) {

            for(Map.Entry<Integer, TrieNode> entry: root.map.entrySet()) {
                // System.out.print(entry.getKey() + " ");
                TrieNode current = entry.getValue();
                view(current);
            }
            //System.out.println("");

        }

    }

    public int bruteForce(int[] nums1, int [] nums2) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    int k = i;
                    int l = j;
                    while( k < nums1.length && l < nums2.length && nums1[k] == nums2[l]) {
                        k++;
                        l++;
                    }

                    max = Integer.max(max, (l-j));
                    // System.out.println(" The current max is => " + max);
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
