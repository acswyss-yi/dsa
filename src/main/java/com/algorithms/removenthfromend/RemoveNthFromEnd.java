package com.algorithms.removenthfromend;

/**删除链表中倒数第 N 个节点

思路：快慢双指针（一次遍历）

  - fast 先走 n+1 步
  - fast 和 slow 同步前进，直到 fast 到达末尾
  - 此时 slow.next 就是要删除的节点

初始：dummy -> 1 -> 2 -> 3 -> 4 -> 5,  n=2

fast 先走 n+1=3 步：
slow = dummy, fast = 3

同步前进直到 fast == null：
slow = 3, fast = null（越过末尾）

slow.next = slow.next.next → 删除 4
结果：1 -> 2 -> 3 -> 5 ✓
 **/

public class RemoveNthFromEnd {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哑节点，处理删除头节点的边界情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast 先走 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // fast、slow 同步前进，直到 fast 越过末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow.next 即为待删除节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}
/**
复杂度分析

  ┌────────┬──────┬──────────────────────────┐
          │ 复杂度 │  值  │           说明           │
        ├────────┼──────┼──────────────────────────┤
        │ 时间   │ O(L) │ L 为链表长度，只遍历一次 │
        ├────────┼──────┼──────────────────────────┤
        │ 空间   │ O(1) │ 只用了两个指针           │
        └────────┴──────┴──────────────────────────┘

关键点：哑节点（dummy node）

加一个 dummy.next = head 的虚拟头节点，可以统一处理"删除头节点"这个边界情况，无需单独 if 判断，代码更简洁。
 **/

