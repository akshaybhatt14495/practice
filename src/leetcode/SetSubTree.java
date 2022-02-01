package leetcode;

import java.util.Set;

public class SetSubTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);
        root.right= new TreeNode(5);


        TreeNode subTree = new TreeNode(4);
        subTree.left=new TreeNode(1);
        subTree.right=new TreeNode(2);
        System.out.println(new SetSubTree().isSubtree(root, subTree));


    }
  static public class TreeNode {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root!=null  && compare(root, subRoot)) {
            return  true;
        } else if (root ==null){
            return false;
        } else{
            return isSubtree(root.right , subRoot) || isSubtree(root.left , subRoot);
        }
    }
    boolean compare(TreeNode expected, TreeNode current) {
        if (expected == null && current== null) {
            return true;
        }

        if (expected !=null && current != null && expected.val==current.val) {
            return compare(expected.left, current.left) && compare(expected.right, current.right);
        } else {
            return false;
        }

    }
}
