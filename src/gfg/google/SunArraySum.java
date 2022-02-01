package gfg.google;

import java.util.ArrayList;
import java.util.Scanner;

public class SunArraySum {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> output = new ArrayList<>();
        output.add(-1);

        if (n==1 && arr[0] == s) {
            output.add(1);
            output.add(1);
            return output;
        }
        //1,2,436,6,7687,5,76,8,86,
        //i, j slide as per condition
        int l=0, r=l;
        int sum=arr[r];
        while (l < n && r <n && l<=r ) {
            if (sum < s) {
                r++;if (r==n) {
                    break;
                }
                sum+=arr[r];
            } else if (sum>s) {
                sum-=arr[l];
                if (l==r) {
                    l++;r++;
                    if (r==n) {
                        break;
                    }
                    sum+=arr[r];
                } else {
                    l++;
                }


            } else {
                output=  new ArrayList<>();
                output.add(l+1);
                output.add(r+1);
                break;
            }
        }
        return output;
    }
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0; i< n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(subarraySum(arr, n, sum));
    }
}
