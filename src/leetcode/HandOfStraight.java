package leetcode;

import java.util.*;

//https://leetcode.com/problems/hand-of-straights/
public class HandOfStraight {
    public static void main(String[] args) {


    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length%groupSize !=0) {
            return false;
        }
        SortedMap<Integer, Integer> map = new TreeMap();

        for (int i : hand) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) +1);
            } else {
                map.put(i, 1);
            }
        }
        Collections.sort(new ArrayList<Integer>(), (o1, o2)-> (o1-o2));
        while (map.size()>0) {
            int first = map.firstKey();
            for (int i=0;i<groupSize;i++) {
                if (map.containsKey(first)) {
                    int count = map.get(first);
                    if (count ==0) {
                        return false;
                    } else {
                        if (count == 1) {
                            map.remove(first);
                        } else {
                            map.replace(first, count-1);
                        }
                    }
                    first++;
                } else{
                    return false;
                }
            }
        }

        return true;
    }
}
