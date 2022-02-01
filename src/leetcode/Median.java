package leetcode;
public class Median {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int index = length/2;
        int counter = 0;
        int first=0, second=0;
        int i=0;
        int j=0;

        while (i < nums1.length && j < nums2.length && counter <=index) {
            first = second;
            if (nums1[i] >= nums2[j]) {
                second = nums2[j++];
                counter++;

            } else {
                second = nums1[i++];
                counter++;
            }
        }
        while (i < nums1.length && counter <=index) {
            first = second;
            second = nums1[i++];
            counter++;
        }
        while (j < nums2.length && counter <=index) {
            first = second;
            second = nums2[j++];
            counter++;
        }

        double median;
        if (length %2 == 0) {
            return (first +second)/2.0;

        } else {
            return second;
        }

    }
}
