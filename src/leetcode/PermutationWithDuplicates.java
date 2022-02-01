package leetcode;

import java.util.*;

public class PermutationWithDuplicates {
    public static void main(String[] args) {
        System.out.println(new PermutationWithDuplicates().permute(new int[]{1,1,2}));
    }

    public List<List<Integer>> permute(int[] nums) {


        Set<List<Integer>> result = new HashSet<>();
        permute(nums, result, 0);
        List<List<Integer>> resultList = new ArrayList<>(result);
        Collections.sort(resultList, (o1, o2) -> {
            for (int i=0;i<o1.size(); i++) {
                if (o1.get(i) < o2.get(i)){
                    return -1;
                } else if (o1.get(i) > o2.get(i)) {
                    return 1;
                }
            }
            return 0;
        });
        return resultList;
    }


    public void permute(int[] nums, Set<List<Integer>> result, int pointer) {

        if (pointer==nums.length) {
            List<Integer> intList = new ArrayList<Integer>(nums.length);
            for (int i : nums)
            {
                intList.add(i);
            }
            result.add(intList);
            return;
        }
        for (int i=pointer; i< nums.length; i++) {
            //swap
            int temp = nums[pointer];
            nums[pointer]=nums[i];
            nums[i]=temp;
            permute(nums, result, pointer+1);
            //swap again to get state back
            temp = nums[pointer];
            nums[pointer]=nums[i];
            nums[i]=temp;

        }

    }
}
