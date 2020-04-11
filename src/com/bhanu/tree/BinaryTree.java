package com.bhanu.tree;

public class BinaryTree {

    Node root;

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int x){
            val = x;
            left = null;
            right = null;
        }
    }
    public void add(int value){
        root = addRecursive(root,value);
    }
    private Node addRecursive(Node current,int value){
        if (current == null){
            return new Node(value);
        }
        if (value < current.val){
            current.left = addRecursive(current.left,value);
        }else if (value > current.val){
            current.right = addRecursive(current.right,value);
        }else{
            return current;
        }

        return current;

    }

}
