package com.bhanu;

public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){data = d;}
    }

    public void printAllNodes(){
        Node current = head;
        while (current != null){
            System.out.println("value is:"+current.data);
            Node next = current.next;
            current = next;
        }
    }
    public int getSize(){
        int size = 0;
        Node current = head;
        while (current != null){
            size++;
            Node next = current.next;
            current = next;
        }
        return size;
    }
    private Node getLastNode(){
        Node current = head,prevNode=head;
        while (current != null){
            prevNode = current;
            current = current.next;
        }
        return prevNode;
    }
    public void insertFirst(Node node){
        if (head == null){
            head = node;
            return;
        }
        Node first = head;
        head = node;
        head.next = first;
    }
    public void insertLast(Node node){
        Node current = head,prevNode=null;
        while (current != null){
            Node next = current.next;
            current = next;
            if (current != null){
                prevNode = current;
            }
        }
        prevNode.next = node;
    }
    public void deleteKey(int key){
        if (head != null && head.data == key){
            head = head.next;
            return;
        }

        Node current = head,prevNode=null;
        while (current != null && current.data != key){
            prevNode = current;
            current = current.next;
        }
        if (current != null){
            prevNode.next = current.next;
        }
    }
    public void deleteAt(int position){

        Node current = head,prevNode = null;

        if (position == 0 && current != null){
            head = head.next;
        }

        int index = 0;

        while (current != null){
            if (index == position){
                prevNode.next = current.next;
                break;
            }else{
                prevNode = current;
                current = current.next;
                index++;
            }
        }
    }
    public void findSecondLastNode(){
        Node current = head;
        if (current == null || current.next == null){
            return;
        }
        while (current.next.next != null){
            current = current.next;
        }
        System.out.println("second last node is: "+current.data);
    }
    /**
     * Move last M elements to the front of the linkedlist
     */
    public void moveLastElementsToFirst(int m){
        int slow=0,fast=0;
        Node mFirstNode = head;
        Node current = head;
        Node lastNode = head;
        while (current != null){
            if (fast> m){
                mFirstNode= mFirstNode.next;
                slow++;
            }
            lastNode = current;
            current = current.next;
            fast++;
        }

        //lastNode.next = head;
        //head = mFirstNode.next;
        System.out.println("mFirst element is: "+mFirstNode.data);
        System.out.println("Last node is: "+lastNode.data);
        lastNode.next = head;
        head = mFirstNode.next;
        mFirstNode.next = null;

    }
    /**
     * printing middle elements from linkedlist
     */
    public void middleElement(){
        Node slow_ptr = head;
        Node fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        System.out.println("Middle element is: "+slow_ptr.data);
    }
    /**
     * finding middle element by iterative or recursive approach
     */
    public void midElement(Node head,int n){
        if (head == null){
            n = n/2;
            System.out.println("Middle element is: "+n);
            return;
        }
        n = n+1;
        head = head.next;
        midElement(head,n);
    }
    /**
     * reverse a linked list
     */
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null){
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
        }
        head = prev;
    }
    /**
     * reverse a linked list using recursive mode
     */
    public Node reverseUntil(Node current,Node prev){
        if (current.next == null){
            head = current;
            current.next = prev;
            return head;
        }
        Node next1 = current.next;
        current.next = prev;
        reverseUntil(next1,current);
        return head;
    }
    public void printReverse(Node node){
        if (node == null){
            return;
        }
        printReverse(node.next);
        System.out.println(node.data+" ");
    }

}
