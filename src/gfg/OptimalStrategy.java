package gfg;

public class OptimalStrategy {
    public static void main(String[] args) {
        int []arr= new int[]{8,15,3,7};
        System.out.println(countMaximum(arr, arr.length));
    }
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {

        int i=0, j=n-1;
        return countMaximum(arr, i,j);
    }


    static long countMaximum(int arr[], int i,int j) {
        if (i>=j) {
            return arr[i];
        }
        if (i+1==j) {
            return Math.max(arr[i],arr[j]);
        }
        long firstSelect = arr[i]  + Math.min(countMaximum(arr, i+2, j), countMaximum(arr, i+1, j-1));
        long lastSelect = arr[j] + Math.min(countMaximum(arr, i+1, j-1), countMaximum(arr, i, j-2));
        return Math.max(firstSelect, lastSelect);
    }
}
