import java.util.*;

public class Test {

    public static void main(String[] args) {

        System.out.println(new Test().getPairs(new int[]{4, 7,5, 9,1},2));
    }

    List<List<Integer>> getPairs(int arr[], int diff) {
        HashSet<Integer> set  = new HashSet<>();

        List<List<Integer>> result =new ArrayList<>();
        for (int i: arr) {
            if (set.contains(i-diff))  {
                result.add(Arrays.asList(i, i-diff));
            }
            if (set.contains(i+diff))  {
                result.add(Arrays.asList(i, i+diff));
            }
            set.add(i);
        }

        return result;
    }
}
