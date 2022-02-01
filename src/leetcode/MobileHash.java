package leetcode;

import java.util.*;

public class MobileHash {
    public static void main(String[] args) {
        MobileHash mb = new MobileHash();
        System.out.println(mb.letterCombinations(""));
    }
    Map<Character, List<Character>> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result= new ArrayList<>();
        setCombinations(digits, 0, result);
        return result;
    }

    void setCombinations(String digits, int idx, List<String> result) {
        if (idx == digits.length()) {
            if (digits.isEmpty()) {
                return;
            }
            result.add(digits);
            return;
        }
        char current = digits.charAt(idx);
        List<Character> chList = map.get(current);
        for (char ch: chList) {
            setCombinations( digits.substring(0, idx) + ch + digits.substring(idx+1), idx+1, result);
        }

    }

}
