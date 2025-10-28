package com.algorithms.binarytodecimal;

public class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
    }

    public void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("empty");
        } else {
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public int binaryToDecimal() {
        int decimalValue = 0;
        Node current = head;
        while(current != null) {
            decimalValue = decimalValue * 2 + current.value;
            current = current.next;
        }
        return decimalValue;
    }

    //   +===================================================+
    //   |               WRITE YOUR CODE HERE                |
    //   | Description:                                      |
    //   | - This method converts a binary number,           |
    //   |   represented as a linked list, to a decimal int. |
    //   |                                                   |
    //   | Return type: int                                  |
    //   | - Returns the decimal equivalent of the binary    |
    //   |   number.                                         |
    //   |                                                   |
    //   | Tips:                                             |
    //   | - We use a while loop to traverse the linked list.|
    //   | - Multiply the current sum by 2 and add the value |
    //   |   at each node to get the decimal number.         |
    //   +===================================================+

}



