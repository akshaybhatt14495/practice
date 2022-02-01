package leetcode;

import java.util.*;

public class Triplets {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        /*for (int i=0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for(int k=j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }*/


        Arrays.sort(nums);

        for (int i=0 ; i< nums.length-2; i++) {

            int x = nums[i];

            int sum = 0-nums[i];

            int start = i+1; int end = nums.length -1;

            while ( start < nums.length && end > 0 && start < end) {
                if (nums[start] + nums[end] == sum) {
                    set.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start ++; end --;
                }  else if (nums[start] + nums[end] > sum) {
                    end --;
                } else {
                    start++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
