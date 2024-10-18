package Algorithms.TreeAlgorithms;

class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int data;
        boolean color;
        Node left, right, parent;

        Node(int data) {
            this.data = data;
            this.color = RED;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private Node root;

    public void insert(int data) {
        Node node = new Node(data);
        root = bstInsert(root, node);
        fixViolation(node);
    }

    private Node bstInsert(Node root, Node node) {
        if (root == null) {
            return node;
        }

        if (node.data < root.data) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.data > root.data) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    private void fixViolation(Node node) {
        Node parent = null;
        Node grandparent = null;

        while ((node != root) && (node.color == RED) && (node.parent.color == RED)) {
            parent = node.parent;
            grandparent = parent.parent;

            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                if (uncle != null && uncle.color == RED) {
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandparent;
                } else {
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateRight(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            } else {
                Node uncle = grandparent.left;

                if (uncle != null && uncle.color == RED) {
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateLeft(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;

        if (node.right != null) {
            node.right.parent = node;
        }

        temp.parent = node.parent;

        if (node.parent == null) {
            root = temp;
        } else if (node == node.parent.left) {
            node.parent.left = temp;
        } else {
            node.parent.right = temp;
        }

        temp.left = node;
        node.parent = temp;
    }

    private void rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;

        if (node.left != null) {
            node.left.parent = node;
        }

        temp.parent = node.parent;

        if (node.parent == null) {
            root = temp;
        } else if (node == node.parent.left) {
            node.parent.left = temp;
        } else {
            node.parent.right = temp;
        }

        temp.right = node;
        node.parent = temp;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();

        int[] keys = {10, 20, 30, 15};
        for (int key : keys) {
            rbTree.insert(key);
        }

        System.out.println("Inorder traversal of the constructed Red-Black tree is:");
        rbTree.inOrder();
    }
}
