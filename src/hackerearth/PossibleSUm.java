package hackerearth;


import java.util.Scanner;

public class PossibleSUm
{

    public static void main(String args[])
    {

        Scanner sc=new Scanner(System.in);

        int test=sc.nextInt();
        for (int testcases=0;testcases<test;testcases++) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int expectedSum=8;
            if (checkSum(arr, 0, expectedSum)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

    public static boolean checkSum(int []arr, int i, int sum) {
        if (i==arr.length) {
            if (sum==0) {
                return true;
            } else {
                return false;
            }

        }
        if (sum==0) {
            return true;
        }
        return checkSum(arr, i+1, sum) || checkSum(arr, i+1, sum-arr[i]);

    }
}
