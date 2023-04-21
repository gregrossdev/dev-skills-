// 8ktu Sum of positive
export function positiveSum(arr:number[]):number 
{
  let output: number = 0; 
  arr.forEach(num => num > 0 && (output += num))
  return output; 
}