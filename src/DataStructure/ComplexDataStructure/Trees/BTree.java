package DataStructure.ComplexDataStructure.Trees;

class BTreeNode {
    int[] keys;
    int m; // Minimum degree (defines the range for number of keys)
    BTreeNode[] children;
    int n; // Current number of keys in the node
    boolean leaf;

    public BTreeNode(int m, boolean leaf) {
        this.m = m;
        this.leaf = leaf;
        this.keys = new int[2 * m - 1];
        this.children = new BTreeNode[2 * m];
        this.n = 0;
    }
}

public class BTree {
    private BTreeNode root;
    private int m; // Minimum degree

    public BTree(int t) {
        this.root = null;
        this.m = m;
    }
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(BTreeNode x, int key) {
        int i = 0;
        while (i < x.n && key > x.keys[i]) {
            i++;
        }

        if (i < x.n && key == x.keys[i]) {
            // Key found in this node
            return true;
        }

        if (x.leaf) {
            // If the node is a leaf and key is not present
            return false;
        }

        // Recur to the appropriate child
        return search(x.children[i], key);
    }

    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(m, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * m - 1) {
                // If root is full, create a new root and split the old root
                BTreeNode newRoot = new BTreeNode(m, false);
                newRoot.children[0] = root;
                splitChild(newRoot, 0);
                root = newRoot;
            }
            insertNonFull(root, key);
        }
    }

    private void insertNonFull(BTreeNode x, int key) {
        int i = x.n - 1;
        if (x.leaf) {
            // Insert key into a leaf node
            while (i >= 0 && key < x.keys[i]) {
                x.keys[i + 1] = x.keys[i];
                i--;
            }
            x.keys[i + 1] = key;
            x.n++;
        } else {
            // Insert into a non-leaf node
            while (i >= 0 && key < x.keys[i]) {
                i--;
            }
            i++;
            if (x.children[i].n == 2 * m - 1) {
                // If the child is full, split it
                splitChild(x, i);
                if (key > x.keys[i]) {
                    i++;
                }
            }
            insertNonFull(x.children[i], key);
        }
    }

    private void splitChild(BTreeNode x, int i) {
        BTreeNode y = x.children[i];
        BTreeNode z = new BTreeNode(m, y.leaf);
        x.children[i + 1] = z;
        x.n++;

        // Move the middle key of y to x
        for (int j = m - 1; j < 2 * m - 2; j++) {
            z.keys[j - m + 1] = y.keys[j];
        }
        x.keys[i] = y.keys[m - 1];
        y.n = m - 1;

        // Move the last t-1 children of y to z
        if (!y.leaf) {
            for (int j = m; j < 2 * m - 1; j++) {
                z.children[j - m] = y.children[j];
            }
        }

        // Adjust the number of keys in y
        y.n = m - 1;
    }

    public static void main(String[] args) {
        BTree bTree = new BTree(3);

        int[] keys = { 3, 8, 1, 7, 5, 12, 6, 9, 10, 11, 2, 4 };

        for (int key : keys) {
            bTree.insert(key);
            System.out.println("After inserting " + key + ":");
            bTree.inOrderTraversal(bTree.root);
            System.out.println();
        }
    }

    // Utility method for in-order traversal
    private void inOrderTraversal(BTreeNode node) {
        if (node != null) {
            for (int i = 0; i < node.n; i++) {
                if (!node.leaf) {
                    inOrderTraversal(node.children[i]);
                }
                System.out.print(node.keys[i] + " ");
            }
            if (!node.leaf) {
                inOrderTraversal(node.children[node.n]);
            }
        }
    }
}