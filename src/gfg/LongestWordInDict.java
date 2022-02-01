package gfg;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDict {

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("clea", "monkey", "plea")));
    }
    static String findLongestWord(String S, List<String> d) {
        // code here

        String maxString = "";
        for (String data : d) {
            int i=0, j = 0;
            while (i < S.length() && j < data.length()) {

                if (S.charAt(i) == data.charAt(j)) {
                    i++; j++;
                } else {
                    i++;
                }
            }

            if (j == data.length()) {
                if (maxString.length() < data.length()) {
                    maxString = data;
                } else if (maxString.length() < data.length()) {
                    if (maxString.compareTo(data) > 0) {
                        maxString = data;
                    }
                }
            }

        }
        return maxString;
    }
}