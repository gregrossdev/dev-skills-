// Array.diff
export function arrayDiff(a: number[], b: number[]): number[] {
  return a.filter((num) => !b.includes(num))
}

// Create Phone Number
export function createPhoneNumber(numbers: number[]): string {
  let phone: string = numbers.join(''); 
  return `(${phone.substring(0, 3)}) ${phone.substring(3, 6)}-${phone.substring(6)}`;
}