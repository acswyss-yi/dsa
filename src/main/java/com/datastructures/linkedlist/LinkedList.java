package com.datastructures.linkedlist;

import org.w3c.dom.Node;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node initialNode = new Node(value);
        this.head = initialNode;
        this.tail = initialNode;
        this.length = 1;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.length++;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void getHead() {
        if (head != null) {
            System.out.println("Head: " + head.value);
        } else {
            System.out.println("List is empty.");
        }
    }

    public void getTail() {
        if (tail != null) {
            System.out.println("Tail: " + tail.value);
        } else {
            System.out.println("List is empty.");
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node current = head;
        Node previous = head;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        tail = previous;
        previous.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return current;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


}
