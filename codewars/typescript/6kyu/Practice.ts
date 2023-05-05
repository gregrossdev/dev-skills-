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
  const sequence: number[] = [a, b, c];
  for (let i = 3; i < n; i++) {
    const next = sequence[i-3] + sequence[i-2] + sequence [i-1];
    sequence.push(next);
  }
  return sequence.slice(0, n);
}

// Highest Scoring Word
export const high = (str: string): string => {
  let words = str.split(' ');
  let strMax = 0;
  let strRes = '';
  for(let i = 0; i < words.length; i++){
    let word = words[i];
    let sum = 0;

    for(let j = 0; j < word.length; j++)
      sum += (word.charCodeAt(j) - 96);
    
    if(sum > strMax){
      strMax = sum;
      strRes = word;
    }
  }

  return strRes;
}

// Equal Sides Of An Array
export function findEvenIndex(arr: number[]): number {
  let N = arr.length;

  let rightsum = 0;
  arr.forEach(num => rightsum += num)
  
  let leftsum = 0;
  for(let i = 0; i < N; i++) {
    rightsum -= arr[i];
    if(leftsum === rightsum) return i;
    leftsum += arr[i];
  }
  
  return -1;
}