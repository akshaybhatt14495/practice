package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class ForestFromBinTree {

    public static void main(String[] args) {
        //[1,2,3,4,5,6,7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new ForestFromBinTree().delNodes(root, new int[]{3,5}));
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<TreeNode> nodes = new HashSet<>();
        nodes.add(root);

        for (int i=0; i<to_delete.length; i++) {
            Set<TreeNode> temp=new HashSet<>();
            for (TreeNode r : nodes) {
                TreeNode nodeToDelete = getNode(r, to_delete[i]);
                if (nodeToDelete==null) {
                    temp.add(r);
                    continue;
                } else {

                    if (nodeToDelete.left != null) {
                        temp.add(nodeToDelete.left);
                    }
                    if (nodeToDelete.right != null) {
                        temp.add(nodeToDelete.right);
                    }
                    if (r.val != nodeToDelete.val) {
                        deleteNode(r, to_delete[i]);
                        temp.add(r);
                    }
                    break;
                }

            }
            nodes = temp;
            System.out.println(nodes.size());

        }

        for (TreeNode t :  nodes) {
            result.add(t);
        }

        System.out.println(result.size());
        return result;
    }

    private TreeNode deleteNode(TreeNode root, int node) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.left.val == node) {
            root.left = null;
            return root;
        }
        if (root.right != null && root.right.val == node) {
            root.right = null;
            return root;
        }
        if (deleteNode(root.left, node)!= null) {
            return root;
        };
        if (deleteNode(root.right, node)!= null) {
            return root;
        }
        return null;
    }


    public TreeNode getNode(TreeNode root, int to_delete) {
        if (root==null) {
            return null;
        }

        if (root.val==to_delete) {
            return root;
        }
        TreeNode left = getNode(root.left, to_delete);
        if (left!=null) {
            return left;
        }
        TreeNode right = getNode(root.right, to_delete);
        if (right!=null) {
            return right;
        }
        return null;
    }
}