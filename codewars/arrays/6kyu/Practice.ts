// Array.diff
export function arrayDiff(a: number[], b: number[]): number[] {
  return a.filter((num) => !b.includes(num))
}