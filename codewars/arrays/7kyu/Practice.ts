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