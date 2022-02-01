package gfg;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HeapBasic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i< n;i++) {
            int q = sc.nextInt();
            if (q==1) {
                queue.add(sc.nextInt());
            } else if (q==2) {
                queue.remove(sc.nextInt());
            } else {
                System.out.println(queue.peek());
            }
        }
    }
}
