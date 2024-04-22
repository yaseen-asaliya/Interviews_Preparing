package DataStructure.ComplexDataStructure.Trees;

class _Node {
    int key, height;
    _Node left, right;

    _Node(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVLTree {
    _Node root;

    int height(_Node _Node) {
        if (_Node == null)
            return 0;
        return _Node.height;
    }

    int balanceFactor(_Node _Node) {
        if (_Node == null)
            return 0;
        return height(_Node.left) - height(_Node.right);
    }

    void updateHeight(_Node _Node) {
        if (_Node != null)
            _Node.height = 1 + Math.max(height(_Node.left), height(_Node.right));   
    }

    _Node rightRotate(_Node y) {
        _Node x = y.left;
        _Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    _Node leftRotate(_Node x) {
        _Node y = x.right;
        _Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    _Node insert(_Node _Node, int key) {
        if (_Node == null)
            return new _Node(key);

        if (key < _Node.key)
            _Node.left = insert(_Node.left, key);
        else if (key > _Node.key)
            _Node.right = insert(_Node.right, key);
        else // Duplicate keys are not allowed
            return _Node;

        updateHeight(_Node);

        int balance = balanceFactor(_Node);

        // Left Left Case
        if (balance > 1 && key < _Node.left.key)
            return rightRotate(_Node);

        // Right Right Case
        if (balance < -1 && key > _Node.right.key)
            return leftRotate(_Node);

        // Left Right Case
        if (balance > 1 && key > _Node.left.key) {
            _Node.left = leftRotate(_Node.left);
            return rightRotate(_Node);
        }

        // Right Left Case
        if (balance < -1 && key < _Node.right.key) {
            _Node.right = rightRotate(_Node.right);
            return leftRotate(_Node);
        }

        return _Node; // otherwise (Balance is -1, 0 ,1)
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int[] keys = { 10, 20, 30, 40, 50, 25 };

        for (int key : keys) {
            avlTree.root = avlTree.insert(avlTree.root, key);
        }
    }
}
