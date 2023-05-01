// Sum of odd numbers
export function rowSumOddNumbers(n: number): number {
  return n ** 3; 
}

// Ones and Zeros
export function binaryArrayToNumber(arr: number[]): number{
  // First, we join the array into a string of "0"s and "1"s
  // and then we parse it as a binary number using parseInt
  return parseInt(arr.join(''), 2);
};

// Odd or Even?
export function oddOrEven(array: number[]) {
  if(array.length == 0) return "even";  
  let checkSum = array.reduce((sum, cur) => sum += cur); 
  return checkSum % 2 == 0 ? "even" : "odd"; 
}

// Testing 1-2-3
export function number(array: string[]): string[]{
  return array.map((str,i) => `${i+1}: ${str}`); 
}