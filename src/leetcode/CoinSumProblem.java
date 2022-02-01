package leetcode;

import java.util.*;

public class CoinSumProblem {
    public static void main(String[] args) {
        System.out.println(new CoinSumProblem().combinationSum(new int[]{2,3,7}, 7));
    }
    HashMap<Integer, HashMap<Integer, List<Integer>>> DP = new HashMap<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        getSum(candidates, 0, target, list, new ArrayList<>());
        return  list;
    }

    private void getSum(int[] candidates, int i, int target, List<List<Integer>> result, List<Integer> candidatesList) {

        if (target == 0) {
            result.add(new ArrayList<>(candidatesList));
            return;
        }
        if (target <0 || i == candidates.length) {
            return;
        }
        List<Integer> list = new ArrayList<>(candidatesList);
        list.add(candidates[i]);
        getSum(candidates, i, target-candidates[i], result, list);
        getSum(candidates, i+1, target, result, candidatesList);

    }
}
