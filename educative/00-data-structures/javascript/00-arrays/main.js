//--Challenge: Remove Even Integers From an Array
// Solution 1: Doing it “by hand”
function removeEven(arr) {
    let odds = [];
    for (let num of arr)
        if (arr[num] % 2 != 0)
            odds.push(arr[num])

    return odds;
}

// Solution #2: Using filter() and lambda function
function removeEven(arr) {
    return arr.filter((num => (num % 2) != 0))
}
// time: O(n)
console.log(removeEven([3, 2, 41, 3, 34]))
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
console.log(mergeArrays([4, 5, 6], [-2, -1, 0, 7]))

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
console.log(mergeArrays([4, 5, 6], [-2, -1, 0, 7]))
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
function binarySearch(arr, item) {
    let first = 0, mid;
    let last = arr.length - 1;
    let found = false
    let arrayIndex = -1
    while ((first <= last) && !found) {
        mid = Math.floor((first + last) / 2)
        if (arr[mid] == item) {
            arrayIndex = mid
            found = true
        }
        else {
            if (item < arr[mid])
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

function findSum(arr, value) {
    arr.sort(function (a, b) {
        return a - b
    })
    var index;
    for (var j = 0; j < arr.length; j++) {
        index = binarySearch(arr, (value - arr[j]))
        if (index != false && j != index)
            return [arr[j], value - arr[j]]
    }
    return false;
}

// O(nlogn)
console.log(findSum([1, 2, 3, 4], 5))
console.log(findSum([4, 3, 2, 1], 9))

// Solution #3: Moving indices
function findSum(arr, value) {
    arr.sort(function (a, b) {
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
console.log(findSum([1, 2, 3, 4], 5))
console.log(findSum([1, 2, 3, 4], 10))
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Array of Products of All Elements
// Solution #1: Using a nested loop
function findProduct(arr) {
    var result = []
    var left = 1, currentproduct;
    //To store product of all previous values from currentIndex
    for (var i = 0; i < arr.length; i++) {
        currentproduct = 1
        //To store current product for index i    
        //compute product of values to the right of i index of list
        for (var j = i + 1; j < arr.length; j++) {
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
console.log(findProduct([1, 2, 3, 4, 5]))

// Solution #2: Optimizing the number of multiplications
function findProduct(arr) {
    var temp = 1,
        product = [];
    for (var i = 0; i < arr.length; i++) {
        product[i] = temp;
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
console.log(findProduct([1, 3, 4, 5]))
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Find Minimum Value in Array
// Solution #1: Using a nested loop
function findProduct(arr) {
    var result = []
    var left = 1, currentproduct;
    //To store product of all previous values from currentIndex
    for (var i = 0; i < arr.length; i++) {
        currentproduct = 1
        //To store current product for index i    
        //compute product of values to the right of i index of list
        for (var j = i + 1; j < arr.length; j++) {
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
console.log(findProduct([1, 2, 3, 4, 5]))

// Solution #2: Optimizing the number of multiplications
function findProduct(arr) {
    var temp = 1,
        product = [];
    for (var i = 0; i < arr.length; i++) {
        product[i] = temp;
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
console.log(findProduct([1, 3, 4, 5]))
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Find Minimum Value in Array
// Solution #1: Sort the array
function findMinimum(arr) {
    arr.sort((function (a, b) {
        return a - b
    }))
    return arr[0]
}

//--time: O(nlogn)
console.log(findMinimum([9, 2, 3, 6, -1]))

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
console.log(findMinimum([9, 2, 3, 6, -1]))
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Find First Unique Integer in an Array
// Solution #1
function findFirstUnique(arr) {
    var index2;
    for (var index1 = 0; index1 < arr.length; index1++) {
        index2 = 0
        while (index2 < arr.length) {
            if ((index1 != index2) && (arr[index1] == arr[index2]))
                break
            index2 += 1
        }
        if (index2 == arr.length)
            return arr[index1]

    }
    return null;
}

// time: O(n^2)
console.log(findFirstUnique([9, 2, 3, 6, 2, 6, 9, 0, 3]))

/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Find Second Maximum Value in an Array
// Solution #1: Sort and index
function findSecondMaximum(arr) {
    arr.sort(function (a, b) {
        return a - b
    })
    if (arr.length >= 2)
        return arr[arr.length - 2]
    else
        return null
}

// time: O(nlogn)
console.log(findSecondMaximum([9, 2, 3, 6]))

// Solution #2: Traversing the array twice
function findSecondMaximum(arr) {
    var firstMax = Number.NEGATIVE_INFINITY;
    var secondmax = Number.NEGATIVE_INFINITY;
    for (let item of arr) {
        if (item > firstMax)
            firstMax = item
    }
    for (let item of arr) {
        if ((item < firstMax) && (item > secondmax))
            secondmax = item
    }
    return secondmax
}

// time: O(n)
console.log(findSecondMaximum([9, 2, 3, 6]))

// Solution #3: Finding the Second Largest in one Traversal
function findSecondMaximum(arr) {
    var max = Number.NEGATIVE_INFINITY;
    var secondmax = Number.NEGATIVE_INFINITY;
    for (var val of arr) {
        if (val > max) {
            secondmax = max
            max = val
        } else if (val > secondmax && val != max)
            secondmax = val
    }
    return secondmax
}

// time: O(n)
console.log(findSecondMaximum([9, 2, 3, 6]))

/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Right Rotate an Array by n
// Solution #1: Manual Rotation
function rightRotate(arr, n){ 
    var rotatedList = [] 
    for(var item=arr.length-n;item<arr.length;item++) 
      rotatedList.push(arr[item]) 
    for(var item=0;item<arr.length-n;item++)
      rotatedList.push(arr[item]) 
    return rotatedList 
}

// time: O(n)
console.log(rightRotate([1,2,3,4,5], 3))

// Solution #2: Using splice() and concat()
function rightRotate(arr, n) {
    return (arr.splice(arr.length - n)).concat(arr.splice(0, arr.length))
}

// time: O(n)
console.log(rightRotate([1,2,3,4,5], 3))

/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Rearrange Positive & Negative Values
// Solution #1: Using Auxiliary Arrays
function reArrange(arr){
    var neg = []
    var pos = []
    for(let ele of arr){
      if( ele < 0)
        neg.push(ele)
      else
        pos.push(ele)
    }
    return neg.concat(pos)
  }
  
  // time: O(n)
  console.log(reArrange([10,-1,20,4,5,-9,-6]))

//   Solution #2: Rearranging in Place

function reArrange(arr) {
    var leftMostPosEle = 0,
        tmp;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            if (i != leftMostPosEle) {
                tmp = arr[i];
                arr[i] = arr[leftMostPosEle];
                arr[leftMostPosEle] = tmp;
            }
            leftMostPosEle += 1
        }
    }
    return arr;
}

// time: O(n)
console.log(reArrange([10,-1,20,4,5,-9,-6]))

/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Rearrange Sorted Array in Max/Min Form
// Solution #1: Creating a new array
function maxMin(arr) {
    var result = []
    for (var i = 0; i < (Math.floor(arr.length / 2)); i++) {
        result.push(arr[arr.length - (i + 1)])
        result.push(arr[i])
    }

    if (arr.length % 2)
        result.push(arr[Math.floor(arr.length / 2)])
    return result
}

// time: O(n)
console.log(maxMin([1,2,3,4,5,6,7]))

// Solution #2: Using O(1) Extra Space
function maxMin(arr) {
    var maxIdx = arr.length-1
    var minIdx = 0
    var maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array 
    for( var i = 0; i < (arr.length); i++) {
      // at even indices we will store maximum elements
      if (i % 2 == 0){  
        arr[i] += Math.floor((arr[maxIdx] % maxElem ) * maxElem)
        maxIdx -= 1
      }
      else { // at odd indices we will store minimum elements
        arr[i] += Math.floor((arr[minIdx] % maxElem ) * maxElem)
        minIdx += 1
      }
    }
    // dividing with maxElem to get original values.
    for( var i = 0; i < (arr.length); i++) {
      arr[i] = Math.floor(arr[i] / maxElem)
    }
    return arr
}

arr = [1,2,3,4,5,6,7,8,9];
console.log("Array before min/max:")
console.log(arr)
console.log("Array after min/max: ")
// time: O(n)
console.log(maxMin(arr))

/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
//--Challenge: Maximum Sum Subarray
// Solution #1: (Kadane’s Algorithm)
let findMaxSumSubArray = function(array_) {
    if (array_.length < 1) {
      return 0;
    }
  
    let currMax = array_[0];
    let globalMax = array_[0];
    let lengtharray = array_.length;
    for (let i = 1; i < lengtharray; i++) {
      if (currMax < 0) {
        currMax = array_[i];
      } else {
        currMax += array_[i];
      }
  
      if (globalMax < currMax) {
        globalMax = currMax;
      }
    }
    return globalMax;
  };
  
  v = [-4, 2, -5, 1, 2, 3, 6, -5, 1];

  // time: O(n)
  console.log("Sum of largest subarray: " + findMaxSumSubArray(v));

/////////////////////////////////////////////////////////////////////////////////
