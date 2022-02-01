package gfg;

import java.util.*;

public class KthLargest {
    public static void main(String[] args) {
        System.out.println(kLargest1(new int[]{1,23,12,9,30,2,50}, 7, 3));
    }

    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here
        //max heap
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i=0 ;i< n ; i++) {
            queue.add(arr[i]);
        }
        ArrayList<Integer> data = new ArrayList<>();
        for ( int i=0; i < k; i++) {
            data.add(queue.remove());
        }
        return data;
    }

    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest1(int arr[], int n, int k)
    {
        // code here
        //min heap
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i=0 ;i< n ; i++) {
            if (queue.size() == k) {
                if (queue.peek() < arr[i]) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            } else {
                queue.add(arr[i]);
            }
        }
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> sol = new ArrayList<>();

        for ( int i=0; i < k; i++) {
            data.add(queue.remove());
        }
        for ( int i=data.size() - 1; i >= 0; i--) {
            sol.add(data.get(i));
        }
        return sol;
    }
}
