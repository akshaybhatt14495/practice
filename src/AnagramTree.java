import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramTree {

    public static void main(String[] args) {
        System.out.println(findPermutation("ljr"));
    }

    public static List<String> findPermutation(String s) {
        char []charArr = s.toCharArray();
        Arrays.sort(charArr);

        s = new String(charArr);
        List<String> list = new ArrayList<>();
        if (s.length() == 1) {
            list.add(s);
            return list;
        }
        for (int i = 0; i < s.length(); i++) {
            char data = s.charAt(i);
            List<String> subList = findPermutation(s.substring(0, i) + s.substring(i + 1));
            for (String val : subList) {
                list.add(data + val);
            }
        }
        return list;
    }
}
