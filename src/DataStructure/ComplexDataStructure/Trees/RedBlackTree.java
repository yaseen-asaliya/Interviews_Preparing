package DataStructure.ComplexDataStructure.Trees;

class RBNode {
    int key;
    RBNode parent, left, right;
    int color; // 1 is RED, 2 is BLACK

    public RBNode(int key) {
        this.key = key;
        this.color = 1; // New nodes are always red
        this.parent = this.left = this.right = null;
    }
}

public class RedBlackTree {
    private RBNode root;
    private RBNode nil; // Represents a null node in the tree

    public RedBlackTree() {
        this.nil = new RBNode(0);
        this.nil.color = 2; // Nil nodes are always black
        this.root = this.nil;
    }

    // Insert a key into the Red-Black Tree
    public void insert(int key) {
        RBNode node = new RBNode(key);
        RBNode y = null;
        RBNode x = this.root;

        while (x != this.nil) {
            y = x;
            if (node.key < x.key)
                x = x.left;
            else
                x = x.right;
        }

        node.parent = y;
        if (y == null)
            this.root = node;
        else if (node.key < y.key)
            y.left = node;
        else
            y.right = node;

        node.left = this.nil;
        node.right = this.nil;
        node.color = 1; // New node is red

        insertFixup(node);
    }

    // Fix the Red-Black Tree properties after insertion
    private void insertFixup(RBNode node) {
        while (node.parent.color == 1) {
            if (node.parent == node.parent.parent.left) {
                RBNode y = node.parent.parent.right;
                if (y.color == 1) {
                    node.parent.color = 2; // Change the color of the parent
                    y.color = 2; // Change the color of the uncle
                    node.parent.parent.color = 1; // Change the color of the grandparent
                    node = node.parent.parent; // Move to the grandparent
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = 2; // Change the color of the parent
                    node.parent.parent.color = 1; // Change the color of the grandparent
                    rightRotate(node.parent.parent);
                }
            } else {
                RBNode y = node.parent.parent.left;
                if (y.color == 1) {
                    node.parent.color = 2; // Change the color of the parent
                    y.color = 2; // Change the color of the uncle
                    node.parent.parent.color = 1; // Change the color of the grandparent
                    node = node.parent.parent; // Move to the grandparent
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = 2; // Change the color of the parent
                    node.parent.parent.color = 1; // Change the color of the grandparent
                    leftRotate(node.parent.parent);
                }
            }
        }
        this.root.color = 2; // Ensure the root is black
    }

    // Left rotation
    private void leftRotate(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;

        if (y.left != this.nil)
            y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            this.root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    // Right rotation
    private void rightRotate(RBNode y) {
        RBNode x = y.left;
        y.left = x.right;

        if (x.right != this.nil)
            x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null)
            this.root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    // In-order traversal of the Red-Black Tree
    public void inOrder() {
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(RBNode node) {
        if (node != this.nil) {
            inOrder(node.left);
            System.out.print(node.key + "(" + (node.color == 1 ? "R" : "B") + ") ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();
        int[] keys = { 10, 20, 30, 40, 50, 25 };

        for (int key : keys) {
            rbTree.insert(key);
            System.out.println("After inserting " + key + ":");
            rbTree.inOrder();
        }
    }
}