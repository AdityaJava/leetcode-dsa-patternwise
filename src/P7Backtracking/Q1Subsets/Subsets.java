package P7Backtracking.Q1Subsets;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/submissions/1712111273/
public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> answers = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfsForLoopBased(0, nums, answers, path);
    return answers;
  }

  private void dfsForLoopBased(int start, int[] nums, List<List<Integer>> answers, List<Integer> path) {
    answers.add(new ArrayList<>(path));
    for (int i = start; i < nums.length; i++) {
      path.add(nums[i]);
      dfsForLoopBased(i + 1, nums, answers, path);
      path.removeLast();
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    Subsets subsets = new Subsets();
    subsets.subsets(nums).forEach(System.out::println);
  }
}
