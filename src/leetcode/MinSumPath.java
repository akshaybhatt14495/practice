package leetcode;

public class MinSumPath {
    public static void main(String[] args) {
        System.out.println(new MinSumPath().minPathSum(
                new int[][]{
                        {1,3,1},
                        {1,5,1},{4,2,1},

                }
        ));
    }
    public int minPathSum(int[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int dp[][]=new int[grid.length+1][grid[0].length+1];
        for (int i=0;i<dp.length;i++){
            dp[i][0]=Integer.MAX_VALUE;
        }
        for (int i=0;i<dp[0].length;i++){
            dp[0][i]=Integer.MAX_VALUE;
        }


        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){

                int previous=Math.min(dp[i+1][j],dp[i][j+1]);
                if (previous==Integer.MAX_VALUE){
                    previous=0;
                }
                dp[i+1][j+1]=grid[i][j]+ previous;

            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
