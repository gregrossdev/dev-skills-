
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

// Solution #1: Traversing the Array Twice
class CheckSecondMax {

  public static int findSecondMaximum(int[] arr) {

    int max = Integer.MIN_VALUE;;
    int secondmax = Integer.MIN_VALUE;

    // Find the maximum value in the array by comparing each index with max
    // If an element is greater than max then update max to be equal to it
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) 
        max = arr[i];

    }//end of for-loop

    // Find the second maximum value by comparing each index with secondmax
    // If an element is greater than secondmax and not equal to previously 
    // calculated max, then update secondmax to be equal to that element.
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > secondmax && arr[i] < max) 
        secondmax = arr[i];

    }//end of for-loop

    return secondmax;
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

    int[] arr = {-2, -33, -10, -456};

    System.out.println("Array: " + arrayToString(arr));

    int secMax = findSecondMaximum(arr);

    System.out.println("Second maximum: " + secMax);

  }
}

// Solution #2: Traversing the Array Only Once#
class CheckSecondMax {
  //Returns second maximum value from given Array 
  public static int findSecondMaximum(int[] arr) {

    int max = Integer.MIN_VALUE;;
    int secondmax = Integer.MIN_VALUE;

    // Keep track of Maximum value, whenever the value at an array index is greater
    // than current Maximum value then make that max value 2nd max value and
    // make that index value maximum value  
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        secondmax = max;
        max = arr[i];
      }
      else if (arr[i] > secondmax && arr[i] != max) {
        secondmax = arr[i];
      }
    }//end of for-loop

    return secondmax;
  } //end of findSecondMaximum
  
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

    int[] arr = {-2, -33, -10, -456};

    System.out.println("Array: " + arrayToString(arr));

    int secMax = findSecondMaximum(arr);

    System.out.println("Second maximum: " + secMax);

  }
}

class CheckRotateArray {
  //Rotates given Array by 1 position
  public static void rotateArray(int[] arr) {

    //Store last element of Array.
    //Start from the Second last and Right Shift the Array by one.
    //Store the last element saved on the first index of the Array.
    int lastElement = arr[arr.length - 1];

    for (int i = arr.length - 1; i > 0; i--) {

      arr[i] = arr[i - 1];
    }

    arr[0] = lastElement;
  } //end of rotated array

	// time: O(n)
  public static void main(String args[]) {

    int[] arr = {3, 6, 1, 8, 4, 2};

    System.out.print("Array before rotation: ");
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    rotateArray(arr);

    System.out.print("Array after rotation: ");
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

}

// Solution# 1: Using New Array
class CheckReArrange {

  //Re-Arrange Positive and Negative Values of Given Array 
  public static void reArrange(int arr[]) {

    int[] newArray = new int[arr.length];
    int newArrayIndex = 0;

    //Fill newArray with Negative Values first.
    //Then fill it with postive values.
    //In the end, insert every element of newArray back into original arr.
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0)
        newArray[newArrayIndex++] = arr[i];
    }

    for (int i = 0; i < arr.length; i++) {

      if (arr[i] >= 0)
        newArray[newArrayIndex++] = arr[i];
    }

    for (int j = 0; j < newArrayIndex; j++) {
      arr[j] = newArray[j];
    }
  }
	
	// time: O(n)
  public static void main(String args[]) {
    
    int[] arr = {2, 4, -6, 8, -5, -10};

    System.out.print("Array before re-arranging: ");
    for(int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
    System.out.println();

    reArrange(arr);

    System.out.print("Array after rearranging: ");
    for(int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
  }
}

// Solution# 2: Re-arranging in Place
class CheckReArrange {
  //Re-Arrange Positive and Negative Values of Given Array 
  public static void reArrange(int[] arr) 
  {
    int j = 0; 
    for (int i = 0; i < arr.length; i++) { 
      if (arr[i] < 0) {   // if negative number found
        if (i != j) { 
          int temp = arr[i];
          arr[i] = arr[j]; // swapping with leftmost positive
          arr[j] = temp;
        }
        j++; 
      } 
    } 
  } //end of reArrange()

	// time: O(n)
  public static void main(String args[]) {

    int[] arr = {2, 4, -6, 8, -5, -10};

    System.out.print("Array before re-arranging: ");
    for(int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
    System.out.println();

    reArrange(arr);

    System.out.print("Array after rearranging: ");
    for(int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
  }
}

// Solution #1: Creating a New Array
class CheckMaxMin {

  public static void maxMin(int[] arr) {
    //Create a result array to hold re-arranged version of given arr
    int[] result = new int[arr.length];

    int pointerSmall = 0;     //PointerSmall => Start of arr
    int pointerLarge = arr.length - 1;   //PointerLarge => End of arr

    //Flag which will help in switching between two pointers
    boolean switchPointer = true;

    for (int i = 0; i < arr.length; i++) {
      if (switchPointer)
        result[i] = arr[pointerLarge--]; // copy large values
      else 
        result[i] = arr[pointerSmall++]; // copy small values

      switchPointer = !switchPointer;   // switching between samll and large
    }

    for (int j = 0; j < arr.length; j++) {
      arr[j] = result[j];    // copying to original array
    }
  }

	// time: O(n)
  public static void main(String args[]) {

    int[] arr = {1, 2, 3, 4, 5, 6};
    System.out.print("Array before min/max: ");
    for (int i = 0; i < arr.length; i++) 
      System.out.print(arr[i] + " ");
    System.out.println();

    maxMin(arr);

    System.out.print("Array after min/max: ");
    for (int i = 0; i < arr.length; i++) 
      System.out.print(arr[i] + " ");
    System.out.println();
  }
}

// Solution #2: Using O(1) Extra Space
class CheckMaxMin {

  public static void maxMin(int[] arr) {
    int maxIdx = arr.length - 1;
    int minIdx = 0;
    int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array 
    for( int i = 0; i < arr.length; i++) {
      // at even indices we will store maximum elements
      if (i % 2 == 0){  
        arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
        maxIdx -= 1;
      }
      else { // at odd indices we will store minimum elements
        arr[i] += (arr[minIdx] % maxElem ) * maxElem;
        minIdx += 1;
      }
    }
    // dividing with maxElem to get original values.
    for( int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] / maxElem;
    }
  }

	// time: O(n)
  public static void main(String args[]) {

    int[] arr = {1,2,3,4,5,6,7,8,9};
    System.out.print("Array before min/max: ");
    for (int i = 0; i < arr.length; i++) 
      System.out.print(arr[i] + " ");
    System.out.println();

    maxMin(arr);

    System.out.print("Array after min/max: ");
    for (int i = 0; i < arr.length; i++) 
      System.out.print(arr[i] + " ");
    System.out.println();
  }
}


}