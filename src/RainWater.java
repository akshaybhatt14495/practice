public class RainWater {
    public static void main(String[] args) {

        System.out.println(trappingWater(new int[]{6,9,9}, 5));
        //        System.out.println(trappingWater(new int[]{2,0,4,0,3,0,6,0,1,0,3,0,2}, 5));
//        System.out.println(trappingWater(new int[]{3,0,0,2,0,4}, 5));
    }

    static int trappingWater(int arr[], int n) {

        // Your code here
        //get maximum block
        int index=0, value=0;

        for (int i=0; i < arr.length ; i++) {
            if (arr[i] > value) {
                value = arr[i];
                index = i;
            }
        }
        int total = 0;
        //first half
        for (int i=0; i < index ; i++) {
            int counter = arr[i];
           while (i < index && counter >= arr[i+1]) {
               i++;
               total = total + (counter - arr[i]);
           }
        }
        //second half

        for (int i=arr.length-1; i > index; i--) {
            int counter = arr[i];
            while (i > index && counter > arr[i-1]) {
                i--;
                total = total + (counter - arr[i]);
            }
        }
        return total;
    }
}
