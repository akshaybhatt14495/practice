package leetcode;

public class MaxSubstring {


    public static int getPalindrome(String s, int left, int right) {
        int factor = 0;
        int length=0;
        while (left >=0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            length++;
        }

        return length;
    }
    public static  String longestPalindrome(String s) {
        String sol = "";
        if (s.length() < 2) {
            return s;
        }
        for (int i=0; i< s.length() -1; i++ ) {
            int v =  getPalindrome(s, i, i);
            if (v*2-1 > sol.length()) {
                sol = s.substring(i-v+1, i+v);
            }
            v =  getPalindrome(s, i, i+1);
            if (v*2 > sol.length()) {
                sol = s.substring(i-v+1, i+v+1);
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
