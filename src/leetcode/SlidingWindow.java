package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class SlidingWindow {

    public static void main(String[] args) {
        int arr[] = new SlidingWindow().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int i:arr) {
            System.out.println(i);
        }
    }
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int i=0;
        int j=0;
        int []result= new int[nums.length-k+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (j=0; j< k; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) +1);
        }
        result[j-k] = map.lastEntry().getKey();
        while (j< nums.length) {
            int leftCount = map.get(nums[i]);
            if (leftCount==1) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i],leftCount  -1);
            }
            map.put(nums[j],  map.getOrDefault(nums[j], 0) +1);
            result[j-k+1] = map.lastEntry().getKey();
            j++;
            i++;
        }
        return result;
    }

    /*
    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]
    Explanation:
    3,
    // 1,3,-1, -3
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0;
        int j=0;
        int []result= new int[nums.length-k+1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (j=0; j< k; j++) {
            while (!deque.isEmpty() && deque.getLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
        }

        result[j-k] = deque.getFirst();
        while (j< nums.length) {
            if (nums[i] == deque.getFirst()) {
                deque.removeFirst();
            }
            i++;

            while (!deque.isEmpty() && nums[j] > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            j++;
            result[j-k] = deque.getFirst();
        }
        return result;
    }
}
