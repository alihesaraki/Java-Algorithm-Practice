package Algorithms.TreeAlgorithms;

class AVLTree {

    private class Node {
        int key, height;
        Node left, right;

        public Node(int d) {
            key = d;
            height = 1;
        }
    }

    private Node root;

    private int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    private int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node node, int key) {
        if (node == null) {
            return (new Node(key));
        }

        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        } else {
            return node; // Duplicate keys are not allowed
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        int[] keys = {10, 20, 30, 40, 50, 25};
        for (int key : keys) {
            tree.insert(key);
        }

        System.out.println("Preorder traversal of the constructed AVL tree is:");
        tree.preOrder();
    }
}
