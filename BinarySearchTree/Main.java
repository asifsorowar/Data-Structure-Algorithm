package com.asifsorowar.BinarySearchTree;

public class Main{
    public static void main(String[]args){
        var tree = new Tree();
        tree.insert(20);
        tree.insert(22);
        tree.insert(10);
        tree.insert(8);
        tree.insert(9);
        tree.insert(7);

//        tree.traversePreOrder();

        System.out.println(tree.BinarySearchTreeMin());

        System.out.println(tree.equals(tree));

        System.out.println(tree.isBinaryTree());

        System.out.println(tree.getNodesAtDistance(2));

        tree.traverseLevelOrder();
    }
}

