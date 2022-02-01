package gfg;

public class BinaryStringGoogle {

    public static void main(String[] args) {

        int n = 3;

        int maxB = 1;
        int maxC = 2;

        System.out.println(getCount(n, maxB, maxC, ""));

    }
    static long countStr(long n)
    {
        int maxB = 1;
        int maxC = 2;

        long DP[][][] = new long[(int)n][maxB+1][maxC+1];

        for (int i=0; i< n; i++) {
            for (int j=0; j< maxB; j++) {
                for (int k=0; k <maxC; k++) {
                    
                }
            }

        }
        return getCount(n, maxB, maxC);
    }
    static long getCount(long n, int maxB, int maxC) {
        if (n == 0) {
            return 1;
        }
        long countA =0, countB=0, countC = 0;
        //A
        if (maxB == 0 && maxC == 0) {
            countA = n;
        } else {
            countA = getCount(n-1, maxB, maxC);
        }
        //B
        if (maxB > 0) {
            countB = getCount(n-1, maxB-1, maxC);
        }
        //C
        if (maxC > 0) {
            countC = getCount(n-1, maxB, maxC-1);
        }

        return countA + countB + countC;
    }
    static long getCount(long n, int maxB, int maxC,  String s) {
        if (n == 0) {
//            System.out.println(s);
            return 1;
        }
        long countA =0, countB=0, countC = 0;
        //A
        if (maxB == 0 && maxC == 0) {
           /* for (int i=0; i < n-1; i++)  {
                s+= "a";
            }
            countA = n-1;
            System.out.println(s);*/
        } else {
            countA = getCount(n-1, maxB, maxC, s+"a");
        }
        //B
        if (maxB > 0) {
            countB = getCount(n-1, maxB-1, maxC, s+"b");
        }
        //C
        if (maxC > 0) {
            countC = getCount(n-1, maxB, maxC-1, s+"c");
        }

        return countA + countB + countC;
    }


}
