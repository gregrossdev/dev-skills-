// 8kyu Sum of positive
export function positiveSum(arr:number[]):number 
{
  let output: number = 0; 
  arr.forEach(num => num > 0 && (output += num))
  return output; 
}

// 8kyu Count of positives / sum of negatives
export function countPositivesSumNegatives(input: any): any[] | number[]
{
  if (input === null || input.length ===0) return [];

  let output: number[] = [0, 0];
  for (const num of input) {
    output[0] += Math.max(0, Math.sign(num));
    output[1] += Math.min(0, num);
  }
  return output;
}