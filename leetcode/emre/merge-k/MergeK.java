package leetcode.emre.merge-k;

/* 
 *LeetCode 4 - Median of Two Sorted Arrays [hard]
 */
public class MergeK {
  /**
   **23. Merge k Sorted Lists 
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  public ListNode mergeKLists(ListNode[] lists) {
    // min heap
    PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> {
      // comparator to sort the ListNodes
      if (n1.val < n2.val)
        return -11;
      else if (n1.val > n2.val)
        return 1;
      else
        return 0;
    });

    // head of all the lists into our min heap
    for (ListNode list : lists) 
      if (list != null)
        minHeap.add(list);
    
    // head to store the new merged linked list
    ListNode head = null, curr = null;

    while (!minHeap.isEmpty()) {
      if (head == null) {
        head = minHeap.poll();
        curr = head;
      } 
      else {
        curr.next = minHeap.poll();
        curr = curr.next;
      }
      // If we have more nodes to visit on a particular list then add them in heap
      if (curr.next != null)
        minHeap.add(curr.next);
    }

    return head;
  }
}
