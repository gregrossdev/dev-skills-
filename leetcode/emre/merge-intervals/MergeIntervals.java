/*
 * LeetCode 56 - Merge Intervals [medium]
 * LeetCode 57 - Insert Interval [hard]
 * LeetCode 986 - Interval List Intersections [medium]
 */

class MergeIntervals {

  /* keywords 
  //*intervals, overlapping items or merging intervals
  */ 

  // 56. Merge Intervals
  public int[][] merge(int[][] intervals) {
    List<int[]> output = new ArrayList<int[]>();
    Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0], o2[0]));

    int start = intervals[0][0];
    int end = intervals[0][1];

    int i =1;
    while(i<intervals.length) {
        int[] interval = intervals[i];
        if(interval[0]<=end) // overlapping intervals
          end = Math.max(interval[1], end);
        else { // non overlapping intervals, add previous and outputet
          output.add(new int[]{start,end});
          start = interval[0];
          end =  interval[1];  
        }
        i++;
    }

    output.add(new int[] {start,end});
    return output.toArray(new int[output.size()][]);
  }


  // 57. Insert Interval
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    int start = 0;
    int end = n - 1;
    while (start < n && newInterval[0] > intervals[start][1]) 
      start++;

    while (end >= 0 && newInterval[1] < intervals[end][0]) 
      end--;
    

    int[][] output = new int[start + n - end][2];

    for (int i = 0; i < start; i++) 
      output[i] = Arrays.copyOf(intervals[i], intervals[i].length); 
    
    output[start][0] = Math.min(newInterval[0], start == n ? newInterval[0] : intervals[start][0]);
    output[start][1] = Math.max(newInterval[1], end == -1  ? newInterval[1]  : intervals[end][1]);


    for (int i = start + 1, j = end + 1; j < n; i++, j++) 
      output[i] = intervals[j];
    
    return output;
  }
  
}