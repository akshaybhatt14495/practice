package gfg;

import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
public class LongestSubStringWithK {
    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe", 3));
    }
    public static int longestkSubstr(String s, int k) {
        // code here
        String maxString = "";
        int maxLength  = 0;
        int i=0,j=0;
        Map<Character, Integer> unique = new HashMap<>();
        while (i < s.length() && j < s.length())  {

            if (unique.size() == k) {
                if (maxLength < i-j) {
                    maxString = s.substring(j, i+1);
                    maxLength = i-j + 1;
    //                    maxString = s.substring(j, i);
                }
                i++;
            }
            if (unique.size() < k) {
                if (unique.containsKey(s.charAt(i))) {
                    unique.put(s.charAt(i), unique.get(s.charAt(i)) + 1);
                } else {
                    unique.put(s.charAt(i),1);
                }
                i++;
            } else if (unique.size() > k) {
                int getCount = unique.get(s.charAt(j));
                if (getCount == 1) {
                    unique.remove(s.charAt(j));
                } else {
                    unique.put(s.charAt(j), unique.get(s.charAt(j)) - 1);
                }
                j++;
            }
        }
        return maxLength;
    }
}
