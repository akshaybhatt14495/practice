package leetcode;

import java.util.Stack;

public class MaxAreaHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i=0;
        for (i=0; i< heights.length;) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i] ) {
                    int top = stack.pop();
                    int area =0;
                    if (stack.isEmpty()) {
                        //lowest height till now
                        area = heights[top] * i;
                    } else {
                        area = heights[top] * (i - stack.peek() -1);
                    }
                    maxArea = Math.max(area, maxArea);

                }
            }

        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area =0;
            if (stack.isEmpty()) {
                //lowest height till now
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - stack.peek() -1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
