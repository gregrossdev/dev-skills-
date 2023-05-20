
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

  // Solution #1: Brute Force
  class CheckSum{   

    public static int[] findSum(int[] arr, int n) 
    {    
      int[] result = new int[2]; // to store the pair of values.
      
      for (int i = 0; i < arr.length; i++) { //traverse arr
        for (int j = i + 1; j < arr.length; j++) { //traverse arr again
          if (arr[i] + arr[j] == n) { // find where sum is equal to n
            result[0] = arr[i];
            result[1] = arr[j];
            return result; // return the pair of numbers
          }
        }
      }
      return arr;  
    }
    
    // time: O(n^2)
    public static void main(String args[]) {

      int n = 9;
      int[] arr1 = {2, 4, 5, 7, 8};
      if(arr1.length > 0){
        int[] arr2 = findSum(arr1, n);
        int num1 = arr2[0];
        int num2 = arr2[1];

        if((num1 + num2) != n)
          System.out.println("Not Found");
        else {
          System.out.println("Number 1 = " + num1);
          System.out.println("Number 2 = " + num2);
          System.out.println("Sum = " +  (n) );

        }
      } else {
        System.out.println("Input Array is Empty!");
      }
    }
  }

  // Solution #2: Sorting the Array
  class CheckSum{ 

    //Helper Function to sort given Array (Quick Sort)          
    public static int partition(int[] arr, int low, int high) { 
      int pivot = arr[high];  
      int i = (low - 1); // index of smaller element 
      for (int j = low; j < high; j++) { 
        // If current element is <= to pivot 
        if (arr[j] <= pivot) { 
          i++; 

          // swap arr[i] and arr[j] 
          int temp = arr[i]; 
          arr[i] = arr[j]; 
          arr[j] = temp; 
        } 
      } 

      // swap arr[i+1] and arr[high] (or pivot) 
      int temp = arr[i + 1]; 
      arr[i + 1] = arr[high]; 
      arr[high] = temp; 

      return i + 1; 
    } 

    public static void sort(int[] arr, int low, int high) { 
      if (low < high) { 
        int pi = partition(arr, low, high); 
        sort(arr, low, pi - 1); 
        sort(arr, pi + 1, high); 
      } 
    } 

    //Return 2 elements of arr that sum to the given value
    public static int[] findSum(int[] arr, int n) {
      //Helper sort function that uses the Quicksort Algorithm
      sort(arr, 0, arr.length - 1);   //Sort the array in Ascending Order

      int Pointer1 = 0;    //Pointer 1 -> At Start
      int Pointer2 = arr.length - 1;   //Pointer 2 -> At End

      int[] result = new int[2];
      int sum = 0;

      while (Pointer1 != Pointer2) {

        sum = arr[Pointer1] + arr[Pointer2];  //Calulate Sum of Pointer 1 and 2

        if (sum < n) 
          Pointer1++;  //if sum is less than given value => Move Pointer 1 to Right
        else if (sum > n) 
          Pointer2--; 
        else {
          result[0] = arr[Pointer1];
          result[1] = arr[Pointer2];
          return result; // containing 2 number 
        }
      }
      return arr; 
    } 
    
    // time: O(nlogn)
    public static void main(String args[]) {

      int n = 9;
      int[] arr1 = {1,2,3,4,5};
      if(arr1.length > 0){
        int[] arr2 = findSum(arr1, n);
        int num1 = arr2[0];
        int num2 = arr2[1];

        if((num1 + num2) != n)
          System.out.println("Not Found");
        else {
          System.out.println("Number 1 = " + num1);
          System.out.println("Number 2 = " + num2);
          System.out.println("Sum = " +  (n) );

        }
      } else {
        System.out.println("Input Array is Empty!");
      }
    }
  }

  class ProductArray  {  
    public static int[] findProduct(int arr[]) { 
      int n = arr.length;
      int i, temp = 1; 
  
      // Allocation of result array
      int result[] = new int[n]; 
  
      // Product of elements on left side excluding arr[i]
      for (i = 0; i < n; i++)  
      { 
        result[i] = temp; 
        temp *= arr[i]; 
      } 
  
      // Initializing temp to 1 for product on right side
      temp = 1; 
  
      // Product of elements on right side excluding arr[i] 
      for (i = n - 1; i >= 0; i--)  
      { 
        result[i] *= temp; 
        temp *= arr[i]; 
      }
  
      return result; 
    } 
    public static String arrayToString(int arr[]){
      if (arr.length > 0){
        String result = "";
        for(int i = 0; i < arr.length; i++) {
          result += arr[i] + " ";
        }
        return result;
      }
      else {
        return "Empty Array!";
      }
    }
    
    // time: O(n)
    public static void main(String args[]) {
  
      int[] arr = {-1, 2, -3, 4, -5};
  
      System.out.println("Array before product: " + arrayToString(arr));
  
      int[] prodArray = findProduct(arr);
  
      System.out.println("Array after product: " + arrayToString(prodArray));
    }
  }

  class CheckMinimum {
  //Returns minimum value from given Array 
  public static int findMinimum(int[] arr) {

    int minimum = arr[0];

    //At every Index compare its value with minimum and if its less 
    //then make that index value new minimum value
    for (int i = 1; i < arr.length; i++) {

      if (arr[i] < minimum) {
        minimum = arr[i];
      }
    }
    return minimum;
  } //end of findMinimum

	// time: O(n)
  public static void main(String args[]) {

    int[] arr = { 9, 2, 3, 6};

    System.out.print("Array : ");
    for(int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
    System.out.println();

    int min = findMinimum(arr);
    System.out.println("Minimum in the Array: " + min);

  }

}



}