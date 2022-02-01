package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {
    public static void main(String[] args) {
        /*
        "ADOBECODEBANC"
"ABC"
         */
        System.out.println(new MinWindowSubString().minWindow("ADOBECODEBANC","ABC"));
    }
    public String minWindow(String s, String t) {

        try{
            Map<Character, Integer> tMap = new HashMap<>();


            for (int i=0;i<t.length();i++) {
                tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
            }

            Map<Character, Integer> sMap = new HashMap<>();

            int i=0;
            int j=0;

            int minString=Integer.MAX_VALUE;
            String resultString = "";
            while (i<s.length() && j<s.length() && i<=j) {

                if (containsSubString(tMap, sMap)) {

                    if (minString > (j-i)) {
                        minString=j-i;
                        resultString = s.substring(i,j);
                    }
                    minString=Math.min(minString, j-i);
                    int count = sMap.getOrDefault(s.charAt(i),0);
                    sMap.put(s.charAt(i), count-1);
                    i++;

                } else {
                    sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j),0)+1);
                    j++;
                }

            }
            while (i<s.length()) {
                if (containsSubString(tMap, sMap)) {
                    if (minString > (j-i)) {
                        minString=j-i;
                        resultString = s.substring(i,j);
                    }
                    minString=Math.min(minString, j-i);
                    int count = sMap.getOrDefault(s.charAt(i),0);
                    sMap.put(s.charAt(i), count-1);
                    i++;
                } else {
                    break;
                }
            }
            if (containsSubString(tMap, sMap) && minString > (j-i)) {
                minString=j-i;
                resultString = s.substring(i,j);
            }
            return resultString;
        }
        catch (Exception ex) {
            System.out.println(s +" --- " + t);
            throw ex;
        }


    }


    boolean containsSubString(Map<Character, Integer> tMap,Map<Character, Integer> sMap) {

        for (Map.Entry<Character, Integer> entry:tMap.entrySet()) {
            int expected = sMap.getOrDefault(entry.getKey(), 0);

            if (expected < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
