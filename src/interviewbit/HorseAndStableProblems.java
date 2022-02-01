package interviewbit;

public class HorseAndStableProblems {
    public static int arrange(String data, int stables) {
        int DP[][] = new int[stables+1][data.length()+1];
        int whiteCountArr[] = new int[data.length()];
        int  whiteCount = 0;
        for (int i=1; i <= data.length(); i++) {
            if (data.charAt(i) == 'W') {
                whiteCountArr[i] = whiteCount +1;
                whiteCount++;
            } else {
                whiteCountArr[i] = whiteCount;
            }
        }


        for (int i=1; i <= data.length(); i++) {
            //one stable, i=5 and white are 3, then black will be 5-3 = 2 (product = 3 *2)
            DP[1][i] = whiteCountArr[i] * ( i - whiteCountArr[i]);
        }

        for (int i=1; i<=stables ; i++) {
            for (int j=1; j <= data.length(); j++) {

              //  for (int k=0; k < )


            }
        }
        return 0;
    }

   /* public int arrange(String A, int B) {
        //C(m, k) = P (j to m) + C(j, k - 1)
        int[][] dp = new int[A.length() + 1][B + 1];
        if(A.length() < B) return -1;
        for(int i = 1; i <= A.length(); i++){
            dp[i][1] = product(A, 0, i - 1);
        }

        // Product
        for(int k = 2; k <= B; k++){
            for(int j = k; j <= A.length(); j++){
                int min = Integer.MAX_VALUE;
                for(int i = k - 1; i <= j - 1; i++){

                    dp[j][k] =  Math.min((dp[i][k - 1] + product(A, i, j - 1)), min);//i = 2 j = 4
                    min = dp[j][k];
                }
            }
        }

        return dp[A.length()][B];

    }

    public int product(String A, int start, int end){
        int W = 0, B = 0;
        for(int i = start; i <= end; i++){
            if(A.charAt(i) == 'W') W++;
            else if(A.charAt(i) == 'B') B++;
        }
        return W * B;
    }*/
}
