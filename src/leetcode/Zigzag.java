package leetcode;

public class Zigzag {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
    public static String convert(String s, int numRows) {
        if (s.length() < 2 || numRows == 1) {
            return s;
        }
        int n = numRows -1;

        int x = 2*n;
        int y=0;
        char []res = new char[s.length()];
        int index = 0;

        for (int i=0;   i < s.length(); i = i + x) {
            res[index++] = s.charAt(i);
        }
        x-=2;
        y+=2;
        for (int i=1; i < numRows - 1; i++) {
            boolean flag = true;

            for (int j=i; j < s.length();) {
                res[index++] = s.charAt(j);
                if (flag) {
                    j = j + x;
                } else {
                    j = j + y;
                }
                flag = !flag;
            }
            x-=2;
            y+=2;
        }

        for (int i=numRows -1; i <s.length() && i >= 0; i = i + y) {
            res[index++] = s.charAt(i);
        }

        return new String(res);
    }
}
