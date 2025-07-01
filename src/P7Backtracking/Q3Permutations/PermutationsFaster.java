package P7Backtracking.Q3Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsFaster {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> answers = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();
    List<Boolean> visited = new ArrayList<>(Collections.nCopies(nums.length, false));
    for (int i = 0; i < nums.length; i++) {
      dfs(i, nums, answers, answer, visited);
    }
    return answers;
  }

  private void dfs(int index, int[] nums, List<List<Integer>> answers, List<Integer> answer, List<Boolean> visited) {
    visited.set(index, true);
    answer.add(nums[index]);
    if (answer.size() == nums.length) {
      answers.add(new ArrayList<>(answer));
      answer.removeLast();
      visited.set(index, false);
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!visited.get(i)) {
        dfs(i, nums, answers, answer, visited);
      }
    }
    visited.set(index, false);
    answer.removeLast();
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    PermutationsFaster permutationsFaster = new PermutationsFaster();
    permutationsFaster.permute(nums).forEach(System.out::println);
  }
}
