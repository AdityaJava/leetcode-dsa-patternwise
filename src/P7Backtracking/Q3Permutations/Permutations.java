package P7Backtracking.Q3Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/permutations/description/
public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> answers = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();
    List<Boolean> visited = new ArrayList<>(Collections.nCopies(nums.length, false));
    dfs(0, nums, answers, answer, visited);
    return answers;
  }

  private void dfs(int index, int[] nums, List<List<Integer>> answers, List<Integer> answer, List<Boolean> visited) {
    if (answer.size() == nums.length) {
      answers.add(new ArrayList<>(answer));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!visited.get(i)) {
        visited.set(i, true);
        answer.add(nums[i]);

        dfs(i, nums, answers, answer, visited);

        visited.set(i, false);
        answer.removeLast();
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    Permutations permutations = new Permutations();
    permutations.permute(nums).forEach(System.out::println);
  }
}