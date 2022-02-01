package leetcode;

public class VerifyingDict {
    public static void main(String[] args) {
        System.out.println(new VerifyingDict().isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArr = new int[26];
        for (int i=0; i<order.length(); i++) {
            orderArr[order.charAt(i)-'a'] = i;
        }
        for (int i=0; i<words.length-1;i++) {
            if (!inOrder(words[i], words[i+1], orderArr)) {
                return false;
            }
        }

        return true;
    }

    boolean inOrder(String lower, String higher, int[]  orderArr) {
        int i=0;
        while (i<lower.length() && i<higher.length()) {
            char l =lower.charAt(i);
            char h =higher.charAt(i);

            if (orderArr[l-'a'] >orderArr[h-'a']) {
                return false;
            } else if (orderArr[l-'a'] <orderArr[h-'a']) {
                return true;
            }else {
                i++;
            }
        }

        if (lower.length() <=higher.length()) {
            return true;
        } else {
            return false;
        }
    }
}
