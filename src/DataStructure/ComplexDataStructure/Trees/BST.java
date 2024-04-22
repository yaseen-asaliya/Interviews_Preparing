package DataStructure.ComplexDataStructure.Trees;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node right, left;
    Node(int data){
        this.data = data;
        right = left = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public Node add(Node current,int data){

        if(current == null) {
            return new Node(data);
        }
        if(data > current.data) {
            current.right = add(current.right, data);
        }
        else if (data < current.data){
            current.left = add(current.left, data);
        }
        return current;
    }

    boolean searchValue(Node root, int target) {
        if(root == null){
            return false;
        }

        if(root.data == target){
            return true;
        }

        boolean res1 = searchValue(root.left, target);
        if(res1) return res1;

        return searchValue(root.left, target);
    }

    int getMax(Node root){
        if(root == null) return 0;
        while (root.right != null){
            root = root.right;
        }
        return root.data;
    }

    Node deleteNode(Node root, int data) {
       if(root == null) return root;
       if(data < root.data){ //search in left sub-tree
           root.left = deleteNode(root.left, data);
       }
       else if(data > root.data){ // search in right sub-tree
           root.right = deleteNode(root.right, data);
       }
       else{ // we found the data
            if(root.left == null){  // one child or lead
                return root.right;
            }
            else if(root.right == null){ // one child or lead
                return root.left;
            }
            else { // has two child
                int maxVal = getMax(root.left); // send right if u wanna search for min value
                root.data = maxVal;
                root.left = deleteNode(root.left, maxVal);
            }
       }
       return root;
    }

    int countEven(Node root){
        if(root == null) return 0;
        int count = 0;

        if(root.data % 2 == 0){
            count = 1 ;
        }

        count += countEven(root.left) + countEven(root.right);
        return count;
    }

    public int getSecondMax(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        Node parent = null;
        while (root.right != null) {
            parent = root;
            root = root.right;
        }

        // If the maximum node (root) has a left subtree, find the maximum in that subtree
        if (root.left != null) {
            return findMax(root.left);
        }

        // If the maximum node does not have a left subtree, return the parent's data
        return parent.data;
    }

    private int findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public int findHighet(Node root) {
        if (root == null) return 0;
        else{
            int leftH = findHighet(root.left);
            int rightH = findHighet(root.right);

            return Math.max(leftH,rightH) + 1;
        }

    }

    // Depth First Search
    public void printPreorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public void printInorder(Node root){
        if(root == null){
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public void printPostorder(Node root){
        if(root == null){
            return;
        }

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");

    }

    // Breadth First Search
    public void BFS(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println(current.data);

            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right !=null){
                queue.add(current.right);
            }
        }
    }

}


public class BST {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.add(tree.root, 80);
        tree.root = tree.add(tree.root, 3);
        tree.root = tree.add(tree.root, 10);
        tree.root = tree.add(tree.root, 1);
        tree.root = tree.add(tree.root, 6);
        tree.root = tree.add(tree.root, 14);
        tree.root = tree.add(tree.root, 4);
        tree.root = tree.add(tree.root, 7);
        tree.root = tree.add(tree.root, 13);

        System.out.println("Preorder:");
        tree.printPreorder(tree.root);
        System.out.println();
        System.out.println("Inorder:");
        tree.printInorder(tree.root);
        System.out.println();
        System.out.println("Postorder:");
        tree.printPostorder(tree.root);
        System.out.println();

        System.out.println(tree.searchValue(tree.root,1));

        tree.root = tree.deleteNode(tree.root, 14);

        tree.printInorder(tree.root);
        System.out.println();

        System.out.println(tree.countEven(tree.root));

        //System.out.println(tree.getSecondMax(tree.root));
        System.out.println(tree.findHighet(tree.root));

        tree.BFS(tree.root);
    }
}
