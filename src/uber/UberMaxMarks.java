package uber;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class UberMaxMarks {
    //[4, 7], [-1, 5], [3, 6]
    public static void main(String[] args) {
        System.out.println(new UberMaxMarks().solution(3, new int[]{
                1,2}));
//        System.out.println(new UberMaxMarks().solution(new int[][]{
//                /*{4,7},
//                {-1,5},
//                {3,6}*/{-10,-9},
//                        {-8,-6},
//                        {0,2},
//                        {1,3},
//                        {2,3}
//        }));
    }
    int solution(int[][] coordinates) {
        if (coordinates.length==0) {
            return 0;
        }

        Arrays.sort(coordinates, (a, b) -> {
            if (a[0] ==b[0]) {
                return a[1]-b[1];
            } else {
                return a[0]-b[0];
            }
        });
        int count = coordinates[0][1] - coordinates[0][0] +1;
        for (int i=1;i<coordinates.length;i++) {
            if (coordinates[i-1][1] >=coordinates[i][0]) {
                if (coordinates[i-1][1] >=coordinates[i][1]) {
                    coordinates[i][1] = coordinates[i-1][1];
                    continue;
                } else {
                    count = count + (coordinates[i][1] -  coordinates[i-1][1]);
                }

            } else {
                count = count + (coordinates[i][1] -  coordinates[i][0]);
            }

        }
        return count;
    }

    int solution(int n, int[] cabTripTime) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int res = 0;
        for(int t : cabTripTime)
            minHeap.offer(new int[] {t, t});
        while(n > 0) {
            int[] cur = minHeap.poll();
            res = Math.max(res, cur[1]);
            cur[1] += cur[0];
            minHeap.offer(cur);
            n--;
        }
        return res;
    }


}
