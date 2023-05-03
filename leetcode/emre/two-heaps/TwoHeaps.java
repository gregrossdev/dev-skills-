package leetcode.emre.two-heaps;

/*
 * LeetCode 480 - Sliding Window Median [hard]
 * LeetCode 502 - IPO [hard]
 */
public class TwoHeaps {
  /**
   **LeetCode 295 - Find Median from Data Stream [hard]
   * Your MedianFinder object will be instantiated and called as such:
   * MedianFinder obj = new MedianFinder();
   * obj.addNum(num);
   * double param_2 = obj.findMedian();
   */
  class MedianFinder {
    
    PriorityQueue<Integer> max = new PriorityQueue(Comparator.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
       min.offer(num);
       max.offer(min.poll());
       if(min.size() < max.size()){
         min.offer(max.poll());
       }
    }
    
    public double findMedian() {
       if(min.size() == max.size()){
         return (min.peek() + max.peek()) / 2.0;
       } else {
         return min.peek();
       } 
    }
}


}
