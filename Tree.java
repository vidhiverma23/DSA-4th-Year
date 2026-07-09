class Node {
    int data;
    Node left;
    Node right;

    Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}

public class Tree {

    Node root;

    Tree() {
        root = null;
    }

    // Inorder Traversal
    void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Inorder traversal of binary tree is:");
        tree.inorder(tree.root);
    }
}