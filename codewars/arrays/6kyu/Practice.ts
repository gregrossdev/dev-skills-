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