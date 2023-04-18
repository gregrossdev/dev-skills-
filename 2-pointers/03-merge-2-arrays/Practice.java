class Practice {

  // 88. Merge Sorted Array
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int tail = m + n - 1; 

    int p1nums1 = m - 1; 
    int p2nums2 = n - 1;
    while(p2nums2 >= 0) 
      if(p1nums1 >= 0 && nums1[p1nums1] > nums2[p2nums2])
          nums1[tail--] = nums1[p1nums1--]; 
      else 
          nums1[tail--] = nums2[p2nums2--];
  }

  // 350. Intersection of Two Arrays II
  public int[] intersect(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);

      int p1nums1 = 0; 
      int p2nums2 = 0;
      List<Integer> cross = new ArrayList<>();
      while(p1nums1 < nums1.length && p2nums2 < nums2.length) {
          if(nums1[p1nums1] < nums2[p2nums2]) 
              p1nums1++;
          else if(nums1[p1nums1] > nums2[p2nums2])
              p2nums2++;
          else {
              cross.add(nums1[p1nums1]);
              p1nums1++;
              p2nums2++;
          }
      }

      int[] output = new int[cross.size()];
      for(int k = 0; k < output.length; k++)
        output[k] = cross.get(k);
      
      return output;
  }

}








}