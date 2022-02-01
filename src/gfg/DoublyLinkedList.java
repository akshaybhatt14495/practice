package gfg;


class Node
{
    Node left, right;
	int data;

	Node(int d)
	{
		data = d;
		left = right = null;
	}

}

//This function should return head to the DLL

public class DoublyLinkedList {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root = bToDLL(root);

        while (root.left != null) {
            root = root.left;
        }
        while (root != null) {
            System.out.println(root.data);
            root = root.right;
        }
    }
    static Node bToDLL(Node root)
    {

        if (root == null) {
            return null;
        }
        if (root.left != null) {
            Node left = bToDLL(root.left);

            while (left.right!= null) {
                left = left.right;
            }

            root.left = left;
            left.right = root;

        }

        if (root.right != null) {

            Node right = bToDLL(root.right);

            while (right.left != null) {
                right =  right.left;
            }
            root.right = right;
            right.left  = root;
        }
        return root;
    }
}
