package hackerrank;

import java.util.*;

public class Grouping {

    public static void main(String[] args) {
//        System.out.println(getMinimumDifference(Arrays.asList("a",
//                "jk",
//                "abb",
//                "mn",
//                "abc"), Arrays.asList("bb",
//                "kj",
//                "bbc",
//                "op",
//                "def")));

        System.out.println(getTheGroups(2, Arrays.asList("Friend",
                "Total"
              ), Arrays.asList(1,
                2), Arrays.asList(2,
                3)));
    }

    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i=0; i < queryType.size(); i++) {
            if (queryType.get(i).equals("Friend")) {
                //set set1
                Set<Integer> set = map.get(students1.get(i));
                if (!map.containsKey(students1.get(i))) {
                    set = new HashSet<>();
                    map.put(students1.get(i), set);
                }
                set.add(students2.get(i));
                set.add(students1.get(i));
                for (Integer common : set) {
                    map.put(common, set);
                }
            }else {
                //get total
                Set<Integer> friend1 = map.get(students1.get(i));
                Set<Integer> friend2 = map.get(students2.get(i));
                int total = 0;
                if (friend1 != null) {
                    total = friend1.size();
                } else {
                    total = 1;
                }
                if (friend2 != null) {
                    total = friend2.size();
                } else {
                    total = 1;
                }

                result.add(total);

            }

        }
        return result;
    }

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        for (int idx=0; idx< a.size(); idx++) {

            String str1 = a.get(idx);
            String str2 = b.get(idx);


            int arr[] = new int[26];
            for (int i=0; i< str1.length(); i++) {
                arr[str1.charAt(i)-'a']++;
            }

            for (int i=0; i< str2.length(); i++) {
                arr[str2.charAt(i)-'a']--;
            }

            int positive = 0, negative = 0;
            for (int i=0; i< arr.length; i++) {
                if (arr[i]>0) {
                    positive += arr[i];
                } else {
                    negative += arr[i];
                }
            }
            if ((positive + negative) != 0) {
                result.add(-1);
            } else {
                result.add(positive);
            }
        }
        return result;

    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i=0; i< arrival.size(); i++) {
            int arrivalTime = arrival.get(i);
            int durationTime = duration.get(i);
            if (map.containsKey(arrivalTime) && map.get(arrivalTime) < durationTime) {

            } else {
                map.put(arrivalTime, durationTime);
            }



        }
        return 0;
    }
}
