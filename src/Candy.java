import java.util.Stack;

public class Candy {
    public static void main(String[] args) {
        System.out.println(collapse("aabbbac"));


    }
    //aabbba
    //a3
    static String collapse(String str) {
        Stack<Block> st = new Stack<>() ;
        for (int i=0; i< str.length() ;) {
            if (st.empty()) {
                st.push(new Block(str.charAt(i), 1));
                i++;
                continue;
            }
            if (st.peek().ch==str.charAt(i)) {
                st.peek().count++;
                i++;
            } else {
                if (st.peek().count >=3) {
                    st.pop();
                    continue;
                } else {
                    st.push(new Block(str.charAt(i), 1));
                    i++;
                }
            }
        }
        String s = new String();
        while(!st.empty()) {
            Block block = st.pop();
            if (block.count >=3) {
                continue;
            }
            for (int i=0; i<block.count; i++ ) {
                s = String.valueOf(block.ch)+ s;
            }
        }
        return s;
    }
}

class Block {
    int count;
    char ch;

    public Block( char ch, int count) {
        this.count = count;
        this.ch = ch;
    }
}
