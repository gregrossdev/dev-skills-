// Array.diff
export function arrayDiff(a: number[], b: number[]): number[] {
  return a.filter((num) => !b.includes(num))
}

// Create Phone Number
export function createPhoneNumber(numbers: number[]): string {
  let phone: string = numbers.join(''); 
  return `(${phone.substring(0, 3)}) ${phone.substring(3, 6)}-${phone.substring(6)}`;
}

// Duplicate Encoder
export function duplicateEncode(word: string){
  let output: string = ""; 
  word = word.toLowerCase(); 
  for(let i=0; i<word.length; i++) {
    if(word.lastIndexOf(word[i]) == word.indexOf(word[i]))
      output += '('; 
    else 
      output += ')'; 
  }

  return output; 
}

// Take a Ten Minutes Walk
export function isValidWalk(walk: string[]) {
  let vertical = 0
  let horizontal = 0; 
  walk.forEach(dir => {
    if (dir == 'n') vertical ++; 
    if (dir == 's') vertical --; 
    if (dir == 'w') horizontal ++; 
    if (dir == 'e') horizontal --; 
  })
  

  return walk.length == 10 && vertical === 0 && horizontal === 0; 
}

// Tribonacci Sequence
export function tribonacci([a, b, c]: [number, number, number], n: number): number[] {
  let output = [a, b, c]; 
  if(n === 1) return [a]; 
  
  for (let i = 3; i <= n; i++) 
    output[i] = output[i - 1] + output[i - 2] + output[i - 3]
  
  return output.slice(0, n); 
}