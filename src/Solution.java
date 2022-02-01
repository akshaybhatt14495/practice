import java.util.Stack;

public class Solution{


    public static void main(String[] args) {
        System.out.println(evaluatePostFix("231*+9-"));
    }

    static Stack<Integer> stack = new Stack<>();

    public static int evaluatePostFix(String s){

        for (int i=0; i<s.length(); i++) {
            char data = s.charAt(i);
            int a ;
            int b;
            if (data >= '0' && data <= '9') {
                stack.push(Integer.parseInt(data + ""));
            } else {
                switch(data) {
                    case '+' :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b+a);
                        break;
                    case '-' :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b-a);
                        break;
                    case '*' :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b*a);
                        break;
                    case '/' :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b/a);
                        break;

                }
            }

        }
        return stack.pop();
        // Your code here
    }
}