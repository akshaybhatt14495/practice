package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateStringBinary {
    public static void main(String[] args) {
        System.out.println(generate_binary_string("1??0?101"));
    }
    public static List<String>generate_binary_string(String s)
    {
        // Code here
        return generate_binary_string(s, 0, "");

    }

    public static List<String> generate_binary_string(String s, int n, String subString)
    {
        if (n >=s.length()) {
            List<String>  list = new ArrayList<>();
            list.add(subString);
            return list;
        }

        if (s.charAt(n) == '?') {

            List<String> l1 = generate_binary_string(s, n+1, subString + "0");

            List<String> l2 = generate_binary_string(s, n+1, subString + "1");
            for (String val : l2) {
                l1.add(val);
            }
            return l1;
        } else  {
            return generate_binary_string(s, n+1, subString + s.charAt(n));
        }
    }
}

