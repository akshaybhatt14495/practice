package gfg;

public class BitwiseTest {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{-36,36}));
        //1010 | 0
        int a =10;
    }
    public static int minimumDifference(int[] nums) {

        int totalSum=0;
        for (int i=0;i<nums.length;i++) {
            totalSum+=nums[i];
        }
        //if 5, then 11 & 5+1==> 6th is 1
        int DP[][]=new int[nums.length+1][Math.abs(totalSum*2)+1];
        for (int i=0;i<DP.length;i++) {
            for (int j=0;j<DP[i].length;j++) {
                DP[i][j]=Integer.MIN_VALUE;
            }
        }
        return recursive(nums, nums.length-1, 0,totalSum, DP);
    }

    public static int recursive(int[] nums, int i, int currentSum, int totalSum ,int DP[][]) {

        int sumIndex=0;
        //
        //0,-1,-2,-3,-4,-5, 1, 2,3,4,5
        if (currentSum<=0) {
            sumIndex=-currentSum;
        } else {
            sumIndex=Math.abs(totalSum)+currentSum;
        }
        if ( DP[i][sumIndex] != Integer.MIN_VALUE) {
            return DP[i][sumIndex];
        }
        if (i==0) {
            return Math.abs((totalSum-currentSum) - currentSum);
        }

        DP[i][sumIndex]= Math.min(recursive(nums, i-1, currentSum+nums[i],totalSum, DP), recursive(nums, i-1, currentSum,totalSum, DP));
        return DP[i][sumIndex];

    }
}
