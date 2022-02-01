package leetcode;

import java.util.*;

public class FrogJump {
    public static void main(String[] args) {
        System.out.println(new FrogJump().canCross(new int[]{0,1,3,6,10,15,16,21}));
    }
    public boolean canCross(int[] stones) {

        List<Set<Integer>> unitsList = new ArrayList<>();
        unitsList.add(new HashSet<>(Arrays.asList(0)));
        for ( int i=1; i< stones.length;i++) {
            HashSet<Integer> currentSet = new HashSet<>();
            for (int j=0; j<i;j++) {
                int diff = stones[i]-stones[j];
                if (unitsList.get(j).contains(diff)) {
                    currentSet.add(diff);
                } else if (unitsList.get(j).contains(diff+1)) {
                    currentSet.add(diff);
                } else if (unitsList.get(j).contains(diff-1)) {
                    currentSet.add(diff);
                }
            }
            if (currentSet.isEmpty()) {
                return false;
            }
            unitsList.add(currentSet);
        }
        return true;
    }
    public boolean canCross(int[] stones, int i, int units) {
        if (i==stones.length-1){
            return true;
        }
        boolean canCross=false;
        for (int idx=i+1; idx<=stones.length-1; idx++) {
            if ((stones[i]+units+1)==stones[idx]) {
                canCross = canCross || canCross(stones, idx,units+1);
                if (canCross==true){
                    return true;
                }
            }
            if ((stones[i]+units)==stones[idx]) {

                canCross = canCross || canCross(stones, idx, units);
                if (canCross==true){
                    return true;
                }
            }
            if ((stones[i]+units-1)==stones[idx]) {
                canCross = canCross || canCross(stones, idx,units-1);
                if (canCross==true){
                    return true;
                }
            }
        }

        return canCross;
    }
}
