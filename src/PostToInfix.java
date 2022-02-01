import java.util.Stack;

public class PostToInfix {


    public static void main(String[] args) {
        System.out.println(evaluatePostFix("231*+9-"));
    }

    static Stack<String> stack = new Stack<>();

    public static String evaluatePostFix(String s){
        for (int i=0; i<s.length(); i++) {
            char data = s.charAt(i);
            String a ;
            String b;
            if (data >= '0' && data <= '9') {
                stack.push((data + ""));
            } else {
                switch(data) {
                    case '+' :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(String.format("(%s+%s)", b, a));
                        break;
                    case '-' :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(String.format("(%s-%s)", b, a));
                        break;
                    case '*' :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(String.format("(%s*%s)", b, a));
                        break;
                    case '/' :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(String.format("(%s/%s)", b, a));
                        break;

                }
            }

        }
        return stack.pop();
        // Your code here
    }
}