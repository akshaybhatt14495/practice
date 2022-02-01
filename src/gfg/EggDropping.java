package gfg;

public class EggDropping
{
    //Function to find minimum number of attempts needed in
    //order to find the critical floor.

    public static void main(String[] args) {
        System.out.println(eggDrop(6,6));
    }
    static int eggDrop(int floors, int eggs)
    {
        int DP[][] = new int[eggs+1][floors+1];
        for (int i=1; i<floors+1; i++) {
            DP[1][i] = i;
            System.out.print(DP[1][i]+"\t");
        }
        System.out.println();

        for (int i=2; i<eggs+1;i++) {
            for (int j=1;j<floors+1;j++) {
                int min = Integer.MAX_VALUE;

                for (int k=1; k<=j;k++) {

                    min = Math.min(min,
                            Math.max(DP[i-1][k-1], DP[i][j-k]));

                }
                DP[i][j] = min+1;
                System.out.print(DP[i][j]+"\t");
            }
            System.out.println();
        }
        return DP[eggs][floors];
    }
}

