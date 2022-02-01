package leetcode;

import java.util.*;

public class CourseSchedule{

    // class to store dependencies as a pair
    static class pair{
        int first, second;

        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    // Returns adjacency list representation from a list
    // of pairs.
    static ArrayList<ArrayList<Integer>> make_graph(int numTasks,
                                                    Vector<pair> prerequisites)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numTasks);

        for(int i=0; i<numTasks; i++){
            graph.add(new ArrayList<Integer>());
        }

        for (pair pre : prerequisites)
            graph.get(pre.second).add(pre.first);

        return graph;
    }

    // A DFS based function to check if there is a cycle
    // in the directed graph.
    static boolean dfs_cycle(ArrayList<ArrayList<Integer>> graph, int node,
                             boolean onpath[], boolean visited[])
    {
        if (visited[node])
            return false;
        onpath[node] = visited[node] = true;

        for (int neigh : graph.get(node))
            if (onpath[neigh] || dfs_cycle(graph, neigh, onpath, visited))
                return true;

        return onpath[node] = false;
    }

    // Main function to check whether possible to finish all tasks or not
    static boolean canFinish(int numTasks, Vector<pair> prerequisites)
    {
        ArrayList<ArrayList<Integer>> graph = make_graph(numTasks, prerequisites);

        boolean onpath[] = new boolean[numTasks];
        boolean visited[] = new boolean[numTasks];

        for (int i = 0; i < numTasks; i++)
            if (!visited[i] && dfs_cycle(graph, i, onpath, visited))
                return false;

        return true;
    }

    public static void main(String args[])
    {
       /* int numTasks = 5;

        Vector<pair> prerequisites = new Vector<pair>();;

        // for prerequisites: [[1, 0], [2, 1], [3, 2]]

        prerequisites.add(new pair(1, 0));
        prerequisites.add(new pair(2, 1));
        prerequisites.add(new pair(3, 2));
        prerequisites.add(new pair(3, 0));
        prerequisites.add(new pair(4, 0));

        if (canFinish(numTasks, prerequisites)) {
            System.out.println("Possible to finish all tasks");
        }
        else {
            System.out.println("Impossible to finish all tasks");
        }*/

        System.out.println(new CourseSchedule().canFinish(2, new int[][]{new int[]{1,0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();

        for (int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i< prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean []visit = new boolean[numCourses];
        boolean []onprocess= new boolean[numCourses];
        System.out.println(graph);
        for (int i=0; i< prerequisites.length; i++) {
            if (!visit[i] && cycle(graph, i,onprocess,visit )) {
                return false;
            }
        }

        return true;
    }

    public boolean cycle(List<List<Integer>> graph, int node,   boolean []onprocess,boolean []visit) {

        if (visit[node]) {
            return false;
        }

        onprocess[node]=visit[node]=true;

        //check for cycle

        for (int i=0; i<graph.get(node).size(); i++) {
            int neigh=graph.get(node).get(i);
            if (onprocess[neigh] || cycle(graph, neigh, onprocess, visit)){
                return true;
            }

        }
        onprocess[node]=false;
        return false;
    }
}

