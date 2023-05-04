package leetcode.emre.subsets;
/*
 * LeetCode 90 - Subsets II [medium]
 */
public class Subsets {
  
  // 78. Subsets
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    if (nums == null) {
        return output;
    }

    output.add(new ArrayList<>());
    for (int num : nums) {
        int size = output.size();
        for (int i = 0; i < size; i++) {
            List<Integer> temp = new ArrayList<>(output.get(i));
            temp.add(num);
            output.add(temp);
        }
    }

    return output;
  }
}
