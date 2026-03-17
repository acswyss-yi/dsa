package com.algorithms.removenthfromend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthFromEndTest {

    private RemoveNthFromEnd solution;

    @BeforeEach
    void setUp() {
        solution = new RemoveNthFromEnd();
    }

    // ---- 工具方法 ----

    private RemoveNthFromEnd.ListNode buildList(int... vals) {
        RemoveNthFromEnd.ListNode dummy = new RemoveNthFromEnd.ListNode(0);
        RemoveNthFromEnd.ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new RemoveNthFromEnd.ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private int[] toArray(RemoveNthFromEnd.ListNode head) {
        int size = 0;
        RemoveNthFromEnd.ListNode cur = head;
        while (cur != null) { size++; cur = cur.next; }
        int[] arr = new int[size];
        cur = head;
        for (int i = 0; i < size; i++) { arr[i] = cur.val; cur = cur.next; }
        return arr;
    }

    // ---- 测试用例 ----

    /** 示例1：删除倒数第2个，[1,2,3,4,5] -> [1,2,3,5] */
    @Test
    void testRemoveSecondFromEnd() {
        RemoveNthFromEnd.ListNode head = buildList(1, 2, 3, 4, 5);
        RemoveNthFromEnd.ListNode result = solution.removeNthFromEnd(head, 2);
        assertArrayEquals(new int[]{1, 2, 3, 5}, toArray(result));
    }

    /** 示例2：只有一个节点，删除后返回空，[1] -> [] */
    @Test
    void testRemoveSingleNode() {
        RemoveNthFromEnd.ListNode head = buildList(1);
        RemoveNthFromEnd.ListNode result = solution.removeNthFromEnd(head, 1);
        assertNull(result);
    }

    /** 示例3：两个节点删除末尾，[1,2] -> [1] */
    @Test
    void testRemoveLastOfTwo() {
        RemoveNthFromEnd.ListNode head = buildList(1, 2);
        RemoveNthFromEnd.ListNode result = solution.removeNthFromEnd(head, 1);
        assertArrayEquals(new int[]{1}, toArray(result));
    }

    /** 删除头节点（倒数第N = 链表长度），[1,2,3] -> [2,3] */
    @Test
    void testRemoveHead() {
        RemoveNthFromEnd.ListNode head = buildList(1, 2, 3);
        RemoveNthFromEnd.ListNode result = solution.removeNthFromEnd(head, 3);
        assertArrayEquals(new int[]{2, 3}, toArray(result));
    }

    /** 删除末尾节点（n=1），[1,2,3,4,5] -> [1,2,3,4] */
    @Test
    void testRemoveLast() {
        RemoveNthFromEnd.ListNode head = buildList(1, 2, 3, 4, 5);
        RemoveNthFromEnd.ListNode result = solution.removeNthFromEnd(head, 1);
        assertArrayEquals(new int[]{1, 2, 3, 4}, toArray(result));
    }

    /** 两个节点删除头节点，[1,2] -> [2] */
    @Test
    void testRemoveHeadOfTwo() {
        RemoveNthFromEnd.ListNode head = buildList(1, 2);
        RemoveNthFromEnd.ListNode result = solution.removeNthFromEnd(head, 2);
        assertArrayEquals(new int[]{2}, toArray(result));
    }
}
