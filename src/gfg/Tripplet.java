package gfg;

import java.util.Arrays;

public class Tripplet {
    public static void main(String[] args) {
        System.out.println(checkTriplet(new int[]{74 ,87 ,22 ,46 ,25 ,73 ,71 ,30 ,78 ,74 ,98 ,13 ,87 ,91 ,62 ,37 ,56 ,68 ,56 ,75 ,32 ,53 ,51 ,51 ,42 ,25 ,67 ,31 ,8 ,92 ,8 ,38 ,58 ,88 ,54 ,84 ,46 ,10 ,10 ,59 ,22 ,89 ,23 ,47 ,7 ,31 ,14 ,69 ,1 ,92 ,63 ,56 ,11 ,60 ,25}, 3));
    }

    static boolean checkTriplet(int[] arr, int n) {
        // code here
        Arrays.sort(arr);

        for (int i=0; i< arr.length; i++) {
            int k=i+2;
            for (int j= i+1; j < arr.length; j++) {
                int sum = arr[i] *arr[i] + arr[j] * arr[j];

                while (k < arr.length && arr[k] * arr[k] < sum ) {
                    k++;
                }
                if (k >= arr.length) {
                    break;
                }
                if ( arr[k]* arr[k] > sum ) {
                    continue;
                }
                if (arr[k]* arr[k] == sum ) {
                    return true;
                }
            }
        }
        return false;
    }
}
