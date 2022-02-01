package leetcode;

import java.util.HashMap;
import java.util.*;
import java.util.Set;

public class MinH {

    //  2--0--1
    public static void main(String[] args) {
        new MinH().findMinHeightTrees(3, new int[][]{
                {1,0},{1,2}
        });
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {


        Map<Integer, Set<Integer>> list = new HashMap<>();

        for (int i=0; i<edges.length;i++) {

            Set<Integer> set = list.getOrDefault(edges[i][0], new HashSet<>());
            set.add(edges[i][1]);
            list.put(edges[i][0], set);
            set = list.getOrDefault(edges[i][1], new HashSet<>());
            set.add(edges[i][0]);
            list.put(edges[i][1], set);


        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : list.entrySet()) {
            if (entry.getValue().size() ==1) {
                q.add(entry.getKey());
            }
        }
        n =list.size();
        while (n>2) {
            int length = q.size();

            for (int i=0; i< length;i++) {

                int pop = q.remove();

                Set<Integer>  neigh = list.get(pop);

                Set<Integer> neighNeigh =list.get(neigh.toArray()[0]);
                neighNeigh.remove(pop);

                if (neighNeigh.size()==1) {
                    int o = (int) neigh.toArray()[0];
                    q.add(o);
                }
                n--;
            }

        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.remove());
        }
        return  result.isEmpty()? Arrays.asList(0): result;

    }


}
