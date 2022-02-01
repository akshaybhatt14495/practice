package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxArraySum {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int sum = Integer.parseInt(firstLine[1]);
        String []secondLine = br.readLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }
        System.out.println(subarraySum(arr, n, sum));
//        System.out.println(subarraySum(new int[]{1,2,3,7,5}, 5, 12));
    }
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int i=0,j=0, sum=0;
        ArrayList<Integer> sol = new ArrayList<>();

        while (j <= i  && i <= n && j <= n) {
            if (sum < s) {
                if (i < n) {
                    sum +=arr[i++];
                }
            } else if (sum > s) {
                if (j < n) {
                    sum -=arr[j++];
                }
            } else {
                sol.add(j+1);
                sol.add(i);
                return sol;
            }
        }

        return null;
    }
}


