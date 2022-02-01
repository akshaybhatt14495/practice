package gfg.commonancestor;

import java.util.ArrayList;
import java.util.List;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class CommonAncestor {
    public static void main(String[] args) {
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + lca(root, 4,5).data);
        System.out.println("LCA(4, 6): " + lca(root, 4,6).data);
        System.out.println("LCA(3, 4): " + lca(root, 3,4).data);
        System.out.println("LCA(2, 4): " + lca(root, 2,4).data);
    }
    static Node lca(Node root, int n1,int n2)
    {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
        Node p = root;
        Node leftTraverse = traverse(p, path1, n1);
        Node rightTraverse = traverse(p, path2, n2);

        if (path1.isEmpty() || path2.isEmpty()) {
            return null;
        }

        int min = Math.min(path1.size(), path2.size());
        int i=0;
        for ( i=0; i< min; i++ ) {
            if (path1.get(path1.size() - 1 - i).data != path2.get(path2.size() - 1 - i).data) {
                return path1.get(path1.size() - i);
            }
        }
        if (path1.size()== path2.size()) {
            return null;
        }
        if (path1.size() == min) {
            return path2.get(i-1);
        } else {
            return path1.get(i-1);
        }

    }

    private static  Node traverse(Node root, List<Node> path, int n) {
       if (root == null) {
           return null;
       }

       Node left = traverse(root.left, path, n);

       if (left != null || root.data == n) {
           path.add(root);
           return root;
       }
        Node right = traverse(root.right, path, n);
       if (right != null) {
           path.add(root);
           return root;
       }
       return null;
    }
}
