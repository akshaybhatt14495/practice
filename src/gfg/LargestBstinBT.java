package gfg;

class MinMax{
    int min;
    int max;
    boolean isBST;
    int size ;

    MinMax(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        isBST = false;
        size = 0;
    }
}
public class LargestBstinBT{
    static int maxSize=0;

    public static void main(String[] args) {

        //7 4 6 N 9
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.right = new Node(9);
        System.out.println(largestBst(root));
    }
    static int largestBst(Node root) {
        int result[] = new int[1];
        result[0] = 0;
        MinMax m = largestBst(root, result);
        return result[0];
    }
    static MinMax largestBst(Node root, int result[])
    {

        if (root==null) {
            return new MinMax();
        }

        MinMax m = new MinMax();
        if (root.left == null && root.right==null) {

            m.min = root.data;
            m.max = root.data;
            m.size=1;
            m.isBST=true;
            result[0] = Math.max(result[0], m.size);
            return m;
        }

        MinMax leftCount = largestBst(root.left,result);
        MinMax rightCount = largestBst(root.right, result);


        if (root.left != null && (!leftCount.isBST || leftCount.max >= root.data )) {
            return new MinMax();
        }

        if (root.right != null && (!rightCount.isBST || rightCount.min <= root.data )) {
            return new MinMax();
        }

        int treeSize= 1 + leftCount.size + rightCount.size;


        m.size = treeSize;
        m.min = Math.min(leftCount.min, root.data);
        m.max = Math.max(rightCount.max, root.data);
        m.isBST=true;
        // System.out.println("treesize" + treeSize);
        result[0] = Math.max(result[0], treeSize);
        return m;

    }

}
