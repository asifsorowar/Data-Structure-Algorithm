package com.asifsorowar.AVLTree;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;


        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    //Recursion
    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);
        if (value < root.value ) root.leftChild =  insert(root.leftChild, value);
        else root.rightChild = insert(root.rightChild, value);

        root.height = height(root);

        root = balance(root);

        return root;
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0) {
                root.leftChild = leftRotate(root.leftChild);
                return rightRotate(root);
            }
            else return rightRotate(root);
        }
        if (isRightHeavy(root) ) {
            if (balanceFactor(root.rightChild) > 0) {
                root.rightChild = rightRotate(root.rightChild);
                return leftRotate(root);
            }
            else return leftRotate(root);
        }
        return root;
    }

    private AVLNode leftRotate(AVLNode node) {
        AVLNode root = node.rightChild;
        node.rightChild = root.leftChild;
        root.leftChild = node;

        node.height = height(node);
        root.height = height(root);

        return root;
    }

    private AVLNode rightRotate(AVLNode node) {
        AVLNode root = node.leftChild;
        node.leftChild = root.rightChild;
        root.rightChild = node;

        node.height = height(node);
        root.height = height(root);

        return root;
    }


    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    public int height() {
        return height(root);
    }

    private int height(AVLNode root) {

        if (root == null) return -1;

        if (root.leftChild == null && root.rightChild == null) return 0;

        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

}
