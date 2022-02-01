public class Sort012 {


    public static void main(String[] args) {
        int []arr = {0, 2, 1, 2, 0};
        sort012(arr, 5);
        System.out.println(arr);
    }

    public static void sort012(int a[], int n)
    {
        int arr[] = new int[3];
        for (int val : a) {
            arr[val]++;
        }
        int count =0;
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i] ; j++) {
                a[count++] = i  ;
            }
        }
    }
}


