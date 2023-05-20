
class Main {

  class CheckRemoveEven {
  
    public static int[] removeEven(int[] arr) {
      int oddElements = 0;
  
      //Find number of odd elements in arr
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] % 2 != 0) oddElements++;
      }
  
      //Create result array with the size equal to the number of odd elements in arr
      int[] result = new int[oddElements];
      int result_index = 0;
  
      //Put odd values from arr to the resulted array
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] % 2 != 0) 
          result[result_index++] = arr[i];
      } //end of for loop
  
      return result;
    } //end of removeEven
  
    // time: O(n)
    public static void main(String args[]) {
    
      int size = 10;
      int[] arr = new int[size]; //declaration and instantiation 
    
      System.out.print("Before removing Even Numbers: "); 
      for (int i = 0; i < arr.length; i++) {
        arr[i] = i; // assigning values
        System.out.print(arr[i] +  " ");
      }
      System.out.println();
    
      int[] newArr =  removeEven(arr); // calling removeEven
    
      System.out.print("After removing Even Numbers: "); 
      for (int i = 0; i < newArr.length; i++) {
        System.out.print(newArr[i] +  " "); // prinitng array
      }
    }
    
  }

  class CheckMergeArray { 

    // Merge arr1 and arr2 into resultantArray
    public static int[] mergeArrays(int[] arr1, int[] arr2) { 
      int s1 = arr1.length;
      int s2 = arr2.length;
      int[] resultantArray = new int[s1+s2];
      int i = 0, j = 0, k = 0;
  
      // Traverse both array 
      while (i < s1 && j < s2) { 
        // Check if current element of first 
        // array is smaller than current element 
        // of second array. If yes, store first 
        // array element and increment first array 
        // index. Otherwise do same with second array 
        if (arr1[i] < arr2[j]) 
          resultantArray[k++] = arr1[i++]; 
        else
          resultantArray[k++] = arr2[j++]; 
      } 
  
      // Store remaining elements of first array 
      while (i < s1) 
        resultantArray[k++] = arr1[i++]; 
  
      // Store remaining elements of second array 
      while (j < s2) 
        resultantArray[k++] = arr2[j++]; 
  
      return resultantArray;
    } 
  
    // time: O(n+m)
    public static void main(String args[]) {
  
      int[] arr1 = {1,12,14,17,23}; // creating a sorted array called arr1
      int[] arr2 = {11,19,27};  // creating a sorted array called arr2
  
      int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays
  
      System.out.print("Arrays after merging: ");
      for(int i = 0; i < arr1.length + arr2.length; i++) {
        System.out.print(resultantArray[i] + " ");
      }
    }
  
  }

  



}