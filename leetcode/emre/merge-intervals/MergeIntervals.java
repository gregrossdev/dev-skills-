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
        else { // non overlapping intervals, add previous and reset
          output.add(new int[]{start,end});
          start = interval[0];
          end =  interval[1];  
        }
        i++;
    }

    output.add(new int[] {start,end});
    return output.toArray(new int[output.size()][]);
  }
  
}