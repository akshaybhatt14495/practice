package gfg;

import java.util.*;

class Permutations {
    public static void main(String[] args) {
        System.out.println(find_permutation("ljr"));
    }
    public static List<String> find_permutation(String str) {
        char[]temp = str.toCharArray();
        Arrays.sort(temp);

        List<String> result =  new ArrayList<>();
        permutation(new String(temp), result, 0);
        Collections.sort(result);
        Map<Integer, Integer> map = new HashMap<>();
        return result;
    }

    static void permutation(String str, List<String> result, int idx) {
        if (idx==str.length()) {
            result.add(str);
            return;
        }
        for (int i=idx; i< str.length(); i++)  {
            char []temp = str.toCharArray();
            char ch = temp[i];
            temp[i]=temp[idx];
            temp[idx] = ch;
            permutation(new String(temp), result, idx+1);
        }
    }

}
