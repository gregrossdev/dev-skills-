

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


  // 202. Happy Number
  class IsHappy {
    public boolean isHappy(int n) {
      int slow = n;
      int fast = n; 
      
      do {
        slow = compute(slow); 
        fast = compute(compute(fast)); 
        if(slow == 1) return true; 
      } 
      while(slow != fast); 
      
      return false; 
    }


    public int compute(int num){
      int n = 0;
      while(num > 0){
        int mod = num % 10;
        n += mod + mod; 
        num /= 10; 
      }
      return n;
    }
  }
  


