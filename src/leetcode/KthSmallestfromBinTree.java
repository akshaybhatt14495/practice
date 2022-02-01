package leetcode;

public class KthSmallestfromBinTree {
    public static void main(String[] args) {
        //[5,3,6,2,4,null,null,1]
        TreeNode root = new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.left.left.left =new TreeNode(1);
        System.out.println(new KthSmallestfromBinTree().kthSmallest(root, 3));
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int kthSmallest(TreeNode root, int k) {


        int []counter= new int[1];

        int []result= new int[1];
        counter[0]=k;
        result[0]=-1;
        kthSmallest(root, counter, result);
        return result[0];
    }

    public int kthSmallest(TreeNode root, int []counter, int []result) {


        if (root==null){
            return -1;
        }

        kthSmallest(root.left,counter ,result);

        if (result[0]!=-1) {
            return result[0];
        }
        if (counter[0]--==1) {
            result[0]=root.val;
            return root.val;
        }


        kthSmallest(root.right,counter ,result);
        return result[0];
    }
}
