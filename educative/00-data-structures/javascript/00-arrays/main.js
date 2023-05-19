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
