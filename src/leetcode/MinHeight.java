package leetcode;

import java.util.*;

public class MinHeight {
    public static void main(String[] args) {
        System.out.println(new MinHeight().findMinHeightTrees(4, new int[][]{
                new int[]{1,0},
                new int[]{1,2},
                new int[]{1,3},
        }));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n==0){
            return new ArrayList<>();
        }
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        int minHeight =Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            graph.put(i, new HashSet<>());
        }

        for (int i=0; i< edges.length; i++) {
            graph.get(edges[i][1]).add(edges[i][0]);
            graph.get(edges[i][0]).add(edges[i][1]);

        }
        Queue<Integer> q= new LinkedList<>();
        for (int i=0;i<n;i++){
            if (graph.get(i).size()==1) {
                q.add(i);
            }
        }


        while (n>2) {
            int outNodes=q.size();
            n=n-outNodes;
            for (int i=0; i<outNodes;i++) {
                int node = q.remove();
                //for sure only one connection
                int neigh = new ArrayList<>(graph.get(node)).get(0);
                graph.get(neigh).remove(node);
                if (graph.get(neigh).size()==1) {
                    q.add(neigh);

                }
                graph.remove(node);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            result.add(q.remove());
        }
        return result;
    }

    public int getHeight( List<List<Integer>> graph, int node, int height, boolean[] visited){
        visited[node]=true;

        if (graph.get(node).isEmpty()) {
            return height;
        }
        int currentNodeHeight=height;
        for (int i=0;i<graph.get(node).size();i++) {
            int neigh=graph.get(node).get(i);
            if (visited[neigh]) {
                continue;
            }
            currentNodeHeight = Math.max(getHeight(graph, graph.get(node).get(i), height+1, visited), currentNodeHeight);
        }
        return currentNodeHeight;
    }
}
