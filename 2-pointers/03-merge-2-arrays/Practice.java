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

}








}