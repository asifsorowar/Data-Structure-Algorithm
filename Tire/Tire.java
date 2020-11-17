package com.asifsorowar.Tire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tire {
    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value= " + value;
        }

        public boolean hasChild(char ch) {
            return this.children.containsKey(ch);
        }

        public void addChild(char ch) {
            this.children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return this.children.get(ch);
        }

        public Node[] getChildren() {
            return this.children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }
        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch:word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null) return false;

        var current = root;
        for (var ch:word.toCharArray()) {
            if (!current.hasChild(ch)) return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void remove(String word) {
        if (word == null) return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) return;

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            child.removeChild(ch);

    }

    private void traversePreOrder(Node root) {
        System.out.println(root.value);

        for (var child:root.getChildren()) {
            traversePreOrder(child);
        }
    }

    private void traversePostOrder(Node root) {
        for (var child:root.getChildren()) {
            traversePostOrder(child);
        }

        System.out.println(root.value);
    }

    public List<String> findWords(String prefix) {
        var lastNode = findLastNodeof(prefix);
        List<String> words = new ArrayList<>();
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if (root == null) return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (var child: root.getChildren())
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNodeof(String prefix) {
        if (prefix == null) return null;

        var current = root;
        for (var ch: prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }
}
