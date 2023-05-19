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
