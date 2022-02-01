package gfg;

import java.util.Stack;

public class Histogram {

    public static void main(String[] args) {
        long []data = new long[]{6,2,5,4,5,1,6};
        System.out.println(getMaxArea(data, data.length ));
    }
    public static long getMaxArea(long hist[], long n)
    {
        // your code here

        Stack<Integer> st = new Stack<>();
        long maxArea =0;
        int i=0;

        while (i<n) {
            long current  =hist[i];
            if (st.isEmpty() || hist[st.peek()] <= hist[i]) {
                st.push(i);
            } else {

                //max height (hist[i])
                //area
                int peek = st.pop();
                long area = hist[i] * (i - peek + 1);
                if (maxArea< area) {
                    maxArea=area;
                }
                st.pop();
            }

        }
        return maxArea;
    }
}
