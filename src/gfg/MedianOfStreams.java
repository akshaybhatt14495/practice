package gfg;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */


    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        Queue<Integer> low = new PriorityQueue<>((o1, o2) -> o2-o1); //maxHeap
        Queue<Integer> high = new PriorityQueue<>(Comparator.comparingInt(o -> o)); //minheap
        List<Double> result = new ArrayList<>();
        for (int x : a) {

            //push
            if (low.isEmpty() && high.isEmpty()) {
                low.add(x);
            } else {
                //low is non empty & it will be rebalanced in case of next code block
                if (x > low.peek()) {
                    high.add(x);
                } else {
                    low.add(x);
                }
            }

            int diff = Math.abs(low.size() - high.size());
            if (diff > 1) {
                if (low.size() > high.size()) {
                    high.add(low.remove());
                } else {
                    low.add(high.remove());
                }
            }
            //get value
            if (high.size() == low.size()) {
                result.add ((high.peek() + low.peek())/2.0);
            } else if (high.size() < low.size()) {
                double d = low.peek();
                result.add( d);
            } else if (high.size() > low.size()) {
                double d = high.peek();
                result.add( d);
            }
        }
        return result;
    }

}

public class MedianOfStreams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/akshay.bhatt/IdeaProjects/test/src/gfg/testFile/median"));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);
        System.out.println(result);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}