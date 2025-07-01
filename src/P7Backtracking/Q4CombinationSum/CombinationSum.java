package P7Backtracking.Q4CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> answers = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();
    dfs(0, candidates, target, answers, answer, 0);
    return answers;
  }

  private void dfs(int start, int[] candidates, int target, List<List<Integer>> answers, List<Integer> answer, int sum) {
    if (sum > target) {
      return;
    }
    if (sum == target) {
      answers.add(new ArrayList<>(answer));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      answer.add(candidates[i]);
      dfs(i, candidates, target, answers, answer, sum + candidates[i]);
      answer.removeLast();
    }
  }

  public static void main(String[] args) {
    //    int[] candidates = { 2, 3, 6, 7 };
    //    int target = 7;

    int[] candidates = { 2, 3, 5 };
    int target = 8;

    CombinationSum combinationSum = new CombinationSum();
    combinationSum.combinationSum(candidates, target).forEach(System.out::println);
  }
}
