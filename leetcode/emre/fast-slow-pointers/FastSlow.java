

class FastSlow {

  
  /**
   **141. Linked List Cycle
   * Definition for singly-linked list.
   * class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) {
   *         val = x;
   *         next = null;
   *     }
   * }
   */
  public boolean hasCycle(ListNode head) {
    ListNode slow = head, 
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      
      if (slow == fast) return true;
    }
    
    return false;
  }
  
  /**
   **142. Linked List Cycle II 
   * Definition for singly-linked list.
   * class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) {
   *         val = x;
   *         next = null;
   *     }
   * }
   */
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if(slow == fast) {
          ListNode current = head; 
          while(current != slow) {
            current = current.next; 
            slow = slow.next; 
          }
          return slow; 
        }
    }
    return null; 
  }