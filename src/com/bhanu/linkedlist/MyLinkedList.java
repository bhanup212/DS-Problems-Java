package com.bhanu.linkedlist;

import java.util.TreeMap;

public class MyLinkedList {

    class Node{
        int val;
        Node next;
        public Node(int value){
            val = value;
        }
    }

    public Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node current = head;
        int count=-1;
        if(head== null){
            return -1;
        }
        while(current != null){
            count++;
            if(index==count){
                return current.val;
            }
            current = current.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }
        Node current = head;

        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int count = -1;
        Node current = head,prev=head;
        Node newNode =new Node(val);
        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        while(current != null){
            count++;
            if(index == count){
                Node temp = prev.next;
                prev.next = newNode;
                newNode.next = temp;
                break;
            }
            prev = current;
            current = current.next;
        }
        if (count == index-1){
            prev.next = newNode;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        Node current = head,prev = head;

        if (index == 0){
            head = current.next;
            return;
        }

        int count = 0;
        while(current != null){
            if(count == index){
                prev.next = current.next;
                current = null;
                break;
            }
            count++;
            prev = current;
            current = current.next;
        }
    }
    public void printAll(){
        Node current = head;
        while (current != null){
            System.out.print(" "+current.val);
            current = current.next;
        }
    }

    public Node removeElements(int val) {

        // 1, 1
        while(head != null && head.val == val){
            head = head.next;
        }
        Node current = head;

        while(current != null && current.next != null){
            if (current.next.val == val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }

        return head;
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        TreeMap<Integer,Node> map= new TreeMap();
        Node currentHeadA = headA;

        while(currentHeadA !=null){
            if(!map.containsKey(currentHeadA.val)){
                map.put(currentHeadA.val,currentHeadA);
            }
            currentHeadA = currentHeadA.next;
        }

        Node currentHeadB = headB;
        while(currentHeadB != null){
            if(map.containsKey(currentHeadB.val)){
                System.out.println("intersection element is: "+currentHeadB.val);
                return currentHeadB;
            }
            currentHeadB = currentHeadB.next;
        }
        System.out.println("intersection element is: null");
        return null;
    }
}
