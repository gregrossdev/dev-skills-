package leetcode.emre.linkedlist-reversal;

/*
 * LeetCode 206 - Reverse Linked List [easy]
 * LeetCode 92 - Reverse Linked List II [medium]
 * LeetCode 25 - Reverse Nodes in k-Group [hard]
 */


class LinkedListReversal {
  /**
   **LeetCode 206 - Reverse Linked List [easy] 
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode() {}
   * ListNode(int val) { this.val = val; }
   * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  public ListNode reverseList(ListNode head) {
    if (head == null)
      return head;

    ListNode prev = null;
    ListNode next = null;

    ListNode current = head;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;

  }

  /**
   **LeetCode 92 - Reverse Linked List II
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode() {}
   * ListNode(int val) { this.val = val; }
   * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
   public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null || left <= 0 || right <= 0 || left == right) 
      return head;
  
    ListNode preHead = new ListNode(0);
    preHead.next = head;

    ListNode prePrev = preHead;

    for (int i = 0; i <= left - 2; i++) 
      prePrev = prePrev.next;
    
    ListNode prev = null;
    ListNode next = null;

    ListNode current = prePrev.next;
    for (int i = 0; i <= right - left; i++) {
      next = current.next; 
      current.next = prev; 
      prev = current; 
      current = next; 
    }

    prePrev.next.next = current;
    prePrev.next = prev;

    return preHead.next;

  }

}
