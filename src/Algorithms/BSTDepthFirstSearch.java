package Algorithms;

class TreeNode {
    int data;
    TreeNode left, right;
}

public class BSTDepthFirstSearch {

    void preorder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void postorder(TreeNode root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Example usage:
        BSTDepthFirstSearch dfs = new BSTDepthFirstSearch();
        TreeNode root = new TreeNode();
        root.data = 1;
        root.left = new TreeNode();
        root.left.data = 2;
        root.right = new TreeNode();
        root.right.data = 3;

        System.out.println("Preorder:");
        dfs.preorder(root);
        System.out.println();

        System.out.println("Inorder:");
        dfs.inorder(root);
        System.out.println();

        System.out.println("Postorder:");
        dfs.postorder(root);
    }
}
