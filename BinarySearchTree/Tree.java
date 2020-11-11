package com.asifsorowar.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var node = new Node(value);

        if (root == null){
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if(value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }

        }

    }

    public boolean find(int value) {
        var current = root;

        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;

            else return true;
        }

        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }


    public int height() {
        return height(root);
    }

    public int min() {
        return min(root);
    }

    // For binary Search Tree // Olog(n)
    public int BinarySearchTreeMin() {
        if (root == null) throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null) return false;
        return equals(root, other.root);
    }

    public boolean isBinaryTree() {
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public List<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);

        return list;
    }

    public void traverseLevelOrder() {
        for (int i=0; i<=height(); i++) {
            var list = getNodesAtDistance(i);
            for (var value:list) System.out.println(value);
        }
    }

    private void getNodesAtDistance(Node root, int distance, List<Integer> list) {
        if (root == null) return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);

    }

    private boolean isBinaryTree(Node root, int min, int max) {
        if (root == null) return true;

        if (root.value < min || root.value > max) return false;

        return isBinaryTree(root.leftChild, min, root.value - 1)
                && isBinaryTree(root.rightChild, root.value - 1, max);


    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;

        if (first != null && second != null)
            return first.value == second.value && equals(first.leftChild, second.leftChild) &&
                    equals(first.rightChild, second.rightChild);

        return false;
    }

    // postOrder - For binary Tree O(n)
    private int min(Node root) {

        if (root == null) return Integer.MAX_VALUE;

        if (isLeaf(root)) return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);

    }

    private boolean isLeaf(Node node) {
        return  (node.leftChild == null && node.rightChild == null);
    }

    private int height(Node root) {
        if (root == null) return -1;
        if (isLeaf(root)) return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }
}
