package P7Backtracking.Q3Permutations;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/description/
public class PermutationsRevision {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> answers = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      dfs(nums, i, answers, new ArrayList<>(), new boolean[nums.length]);
    }
    return answers;
  }

  private void dfs(int[] nums, int index, List<List<Integer>> answers, List<Integer> answer, boolean[] visited) {
    visited[index] = true;
    answer.add(nums[index]);
    if (answer.size() == nums.length) {
      answers.add(new ArrayList<>(answer));
    }
    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        dfs(nums, i, answers, answer, visited);
      }
    }
    visited[index] = false;
    answer.removeLast();
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    PermutationsRevision permutationsRevision = new PermutationsRevision();
    permutationsRevision.permute(nums).forEach(list -> {
      System.out.println(list);
    });
  }
}
