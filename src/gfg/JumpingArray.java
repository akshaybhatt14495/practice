package gfg;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingArray {
    public static void main(String[] args) {
        System.out.println(jumpingNums(100000));
    }
    static long jumpingNums(long X) {

        Queue<Long> q = new LinkedList<>();


        for (int i=1; i<=9;i++) {

            q.add((long)i);

        }
        long last=-1;
        while (!q.isEmpty()) {
            long data = q.remove();
            long remainder = data%10;
            if (remainder > 0) {
                long small = Long.parseLong(data+ String.valueOf(remainder-1));
                if (small > X) {
                    return last;
                } else {
                    last = small;
                }
                q.add(small);
            }
            if (remainder<9) {
                long large = Long.parseLong(data+ String.valueOf(remainder+1));
                if (large > X) {
                    return last;
                } else {
                    last = large;
                }
                q.add(large);
            }
        }

        return 0;

    }
}
