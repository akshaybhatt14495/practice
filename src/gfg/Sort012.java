package gfg;

public class Sort012
{
    public static void main(String[] args) {
        int arr[] = new int[]{0, 2, 1, 2, 0};
//        int arr[] = new int[]{  0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println("etst" instanceof String);
    /*    sort012(arr,arr.length );
        for (int x: arr) {
            System.out.print(x + " ");
        }*/

    }
    public static void sort012(int a[], int n)
    {
        // code here

        int left=0;
        int right=a.length -1;
        while (left < a.length && a[left]==0) {
            left++;
        }
        int mid=left;
        while (mid < a.length && a[mid]==1) {
            mid++;
        }
        while (right >=0 && a[right] == 2) {
            right--;
        }


        while (left < right && (mid < right  || a[mid] == 0 )) {

            if (a[mid] == 0) {
                a[left] = 0;
                a[mid] = 1;
                mid++;
                left++;
            } else if (a[mid] == 2) {
                a[mid] = a[right];
                a[right] = 2;
                right--;
            }else {
                //if 1 then ignore in correct order
                mid++;
            }

            //rebase
            while (left < a.length && a[left]==0) {
                left++;
            }
            while (mid < a.length && a[mid]==1) {
                mid++;
            }
            while (right >=0 && a[right] == 2) {
                right--;
            }
        }
    }
}
