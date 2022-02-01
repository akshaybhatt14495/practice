package gfg;

public class GreaterNumberWithoutIf {

    public static void main(String[] args) {
        System.out.println(getLargest(1034, 12345));
    }

    static int getLargest(int x, int y) {
        //return y ^ ((x ^ y) & -(x < y));
        return 0;
    }
}
