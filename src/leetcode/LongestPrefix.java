package leetcode;

public class LongestPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        String s = new String();
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int maxLength = Integer.MAX_VALUE;
        for (int i=0; i<  maxLength; i++) {

            int j=0;
            char data;
            if (i  < strs[0].length() ) {
                    data = strs[0].charAt(i);
            } else {
                return s;
            }
            for (j=0; j< strs.length; j++) {
                if (strs[j].length() == 0) {
                    return "";
                }
                if (i  < strs[j].length() ) {
                    if (strs[j].charAt(i) != data) {
                        return s;
                    }
                }else {
                    return s;
                }
            }
            s += strs[j-1].charAt(i);
        }
        return s;
    }
}