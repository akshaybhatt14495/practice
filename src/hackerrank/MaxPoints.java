package hackerrank;

import java.util.Arrays;
import java.util.List;

public class MaxPoints {

    public static void main(String[] args) {
        System.out.println(maximumPoints(10, Arrays.asList(5, 2, 3, 1, 4)));
    }
    public static int maximumPoints(int cost, List<Integer> costs) {
        // Write your code here

        int DP[][][]= new int[costs.size()+1][cost+1][2];

        for (int i=0; i< DP.length; i++){
            for (int j=0; j< DP[i].length; j++){
                for (int k=0; k< DP[i][j].length; k++){
                    DP[i][j][k] = -1;
                }
            }
        }
        return Math.max(getPoints(cost, costs, 0, 0, 1, DP), getPoints(cost, costs, 1, 0, 0, DP));
    }
    public static int getPoints(int cost, List<Integer> costs, int idx, int points, int skipPresent, int DP[][][] ) {
        // Write your code here
        if (idx>=costs.size()) {
            return points;
        }

        cost = cost-costs.get(idx);
        if (cost<0) {
            return points;
        }

        if (DP[idx][cost][skipPresent] != -1) {
            return DP[idx][cost][skipPresent];
        }

        int result;
        if (skipPresent==1) {
            int nonSkipped= getPoints(cost, costs, idx+1, points+1, 1, DP) ;
            int skipped=getPoints(cost, costs, idx+2, points+1, 0, DP) ;
            result= Math.max(nonSkipped, skipped);
        } else{
            result= getPoints(cost, costs, idx+1, points+1, 0,DP);
        }
        DP[idx][cost][skipPresent]=result;
        return result;
    }
}
