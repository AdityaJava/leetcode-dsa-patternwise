package P7Backtracking.Q2SubsetsWithDuplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> answers = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();
    Arrays.sort(nums);
    dfsSubsets(nums, 0, answers, paths);
    return answers;
  }

  private void dfsSubsets(int[] nums, int start, List<List<Integer>> answers, List<Integer> paths) {
    answers.add(new ArrayList<>(paths));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i - 1] == nums[i]) {
        continue;
      }
      paths.add(nums[i]);
      dfsSubsets(nums, i + 1, answers, paths);
      paths.removeLast();
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 2 };
    SubsetsWithDuplicates subsets = new SubsetsWithDuplicates();
    subsets.subsetsWithDup(nums).forEach(System.out::println);
  }
}
