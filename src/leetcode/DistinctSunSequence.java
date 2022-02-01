package leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DistinctSunSequence {

    public static void main(String[] args) {
        System.out.println(distinctSubseqII("abaab"));
    }
    public static int distinctSubseqII(String s) {
        int mod = 1_000_000_007;
        int arr[] = new int[s.length()];
        Map<Character,Integer> indexMap = new HashMap<>();
        int total = 1;

        for (int i=0; i< s.length(); i++) {
            int difference = 0;
            if (indexMap.containsKey(s.charAt(i))) {
                if (indexMap.get(s.charAt(i)) == 0) {
                    difference = 1;
                }  else  {
                    difference = arr[indexMap.get(s.charAt(i)) - 1];
                }
            }
            total = total *2 % mod ;
            total -= difference;
            indexMap.put(s.charAt(i), i);
            arr[i] = total;
        }
        total-= 1;
        if (total < 0) {
            total +=mod;
        }
        return  total;
    }
}
