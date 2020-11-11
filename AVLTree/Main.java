package com.asifsorowar.AVLTree;

public class Main {
    public static void main(String[] args) {
        var avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(15);

        System.out.println(avlTree.height());

    }
}
