//--Challenge: Remove Even Integers From an Array
// Solution 1: Doing it “by hand”
function removeEven(arr) {
  let odds = [];
  for(let num of arr)
      if(arr[num] % 2 != 0)
          odds.push(arr[num])

  return odds; 
}

// Solution #2: Using filter() and lambda function
function removeEven(arr) {
    return arr.filter((num => (num % 2) != 0))
}
// time: O(n)
console.log(removeEven([3,2,41,3,34]))
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Merge Two Sorted Arrays
function mergeArrays(arr1, arr2) {
		let merged = arr1.concat(arr2); 
    return merged.sort((a, b) => a - b);
}

// Solution #1: Using the spread operator
function mergeArrays(arr1, arr2) {
    return [...arr1, ...arr2].sort((a, b) => a - b);
}

// time: O(nlogn)
console.log(mergeArrays([4,5,6],[-2,-1,0,7]))

// Solution #2: Creating a new array
function mergeArrays(arr1, arr2) {
    let merged = [];
    let i = 0,
        j = 0;
  //Traverse both arrays and insert smaller value from arr1 or arr2
  //into result array and then increment that array index.
 //If an array is completely traversed, while other one is left then just
 //copy all the remaining elements into result array
    while ((i < arr1.length) && (j < arr2.length)) {
        if (arr1[i] < arr2[j]) {
            merged.push(arr1[i]);
            i++;
        } 
				else {
            merged.push(arr2[j]);
            j++;
        }
    }

    if (i <= (arr1.length - 1)) {
        arr1.splice(0, i)
        merged = merged.concat(arr1);
    } 
		else if (j <= (arr2.length - 1)) {
        arr2.splice(0, j)
        merged = merged.concat(arr2)
    }

    return merged;
}

// time: O(n+m)
console.log(mergeArrays([4,5,6],[-2,-1,0,7]))
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Find Two Numbers that Add up to "value"
// Solution #1: Brute Force
function findSum(arr, value) {
  let n = arr.length; 
  for (let j = 0; j < n; j++) 
     for (let k = j + 1; k < n; k++) 
          if ((arr[j] + arr[k]) == value)
              return [arr[j], arr[k]]
  return false;
}

// time: O(n^2)
console.log(findSum([1, 2, 3, 4], 6))
console.log(findSum([1, 2, 3, 4], 10))

// Solution #2: Sorting the Array
function binarySearch(arr, item){
 let first = 0, mid;
 let last = arr.length - 1;
 let found = false
 let arrayIndex = -1
 while( (first <= last) && !found){
     mid = Math.floor((first + last) / 2)
     if( arr[mid] == item){
         arrayIndex = mid
         found = true
     }
     else{
         if(item < arr[mid])
             last = mid - 1
         else
             first = mid + 1
     }
 }
 if (found)
      return arrayIndex
  else
      return false
}

function findSum(arr,value){
 arr.sort(function(a, b) {
      return a - b
  })
var index;
for(var j = 0; j<arr.length; j++){
 index = binarySearch(arr,(value-arr[j]))
 if(index!=false && j!=index)
   return [arr[j],value-arr[j]]
}
return false;
}

// O(nlogn)
console.log(findSum([1,2,3,4],5))
console.log(findSum([4,3,2,1],9))

// Solution #3: Moving indices
function findSum(arr, value) {
  arr.sort(function(a, b) {
      return a - b
  })
  let index1 = 0,
      index2 = arr.length - 1,
      result = [],
      sum = 0;

  while (index1 != index2) {
      sum = arr[index1] + arr[index2]

      if (sum < value) {
          index1++;
      } 
      else if (sum > value) {
          index2--;
      } 
      else {
          result.push(arr[index1]);
          result.push(arr[index2]);
          return result;
      }
  }

return false;
}

// time: O(nlogn)
console.log(findSum([1,2,3,4],5))
console.log(findSum([1,2,3,4],10))
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Array of Products of All Elements
// Solution #1: Using a nested loop
function findProduct(arr){
  var result = []
  var left = 1, currentproduct;
  //To store product of all previous values from currentIndex
  for(var i=0;i<arr.length;i++){
    currentproduct = 1
    //To store current product for index i    
		//compute product of values to the right of i index of list
    for(var j=i+1;j<arr.length;j++){
      currentproduct = currentproduct * arr[j]
    }
    //currentproduct * product of all values to the left of i index
    result.push(currentproduct * left)
    //Updating `left`
    left = left * arr[i]
  }
    
  return result
}

// time: O(n^2)
console.log(findProduct([1,2,3,4,5]))

// Solution #2: Optimizing the number of multiplications
function findProduct(arr) {
    var temp = 1,
        product = [];
    for (var i = 0; i < arr.length ; i++) {
        product[i]  = temp;
        temp = temp * arr[i];
    }

    temp = 1;
    for (var i = arr.length - 1; i > -1; i--) {
        product[i] *= temp;
        temp *= arr[i];
    }

    return product
}

// time: O(n)
console.log(findProduct([1,3,4,5]))
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Find Minimum Value in Array
// Solution #1: Using a nested loop
function findProduct(arr){
    var result = []
    var left = 1, currentproduct;
    //To store product of all previous values from currentIndex
    for(var i=0;i<arr.length;i++){
      currentproduct = 1
      //To store current product for index i    
          //compute product of values to the right of i index of list
      for(var j=i+1;j<arr.length;j++){
        currentproduct = currentproduct * arr[j]
      }
      //currentproduct * product of all values to the left of i index
      result.push(currentproduct * left)
      //Updating `left`
      left = left * arr[i]
    }
      
    return result
  }
  
  // time: O(n^2)
  console.log(findProduct([1,2,3,4,5]))
  
  // Solution #2: Optimizing the number of multiplications
  function findProduct(arr) {
      var temp = 1,
          product = [];
      for (var i = 0; i < arr.length ; i++) {
          product[i]  = temp;
          temp = temp * arr[i];
      }
  
      temp = 1;
      for (var i = arr.length - 1; i > -1; i--) {
          product[i] *= temp;
          temp *= arr[i];
      }
  
      return product
  }
  
  // time: O(n)
  console.log(findProduct([1,3,4,5]))
  /////////////////////////////////////////////////////////////////////////////////
//--Challenge: Find Minimum Value in Array
// Solution #1: Sort the array
function findMinimum(arr){
    arr.sort((function(a, b){
          return a - b
      }))
    return arr[0]
  }
  
  //--time: O(nlogn)
  console.log(findMinimum([9,2,3,6,-1]))
  
  // Solution #2: Iterate over the array#
  function findMinimum(arr) {
      var currentMin = arr[0];
      //At every Index compare its value with current minimum 
      //and if its less, then make that index value the new minimum value
      for (let val of arr) {
          if (val < currentMin)
              currentMin = val
      }
  
      return currentMin
  }
  
  //--time: O(n)
  console.log(findMinimum([9,2,3,6,-1]))
  /////////////////////////////////////////////////////////////////////////////////