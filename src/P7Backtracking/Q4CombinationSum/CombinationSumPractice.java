package P7Backtracking.Q4CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumPractice {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> answers = new ArrayList<>();
    Arrays.sort(candidates);
    for (int i = 0; i < candidates.length; i++) {
      dfs(candidates, i, target, answers, new ArrayList<>(), 0);
    }
    return answers;
  }

  private void dfs(
    int[] candidates,
    int index,
    int target,
    List<List<Integer>> answers,
    List<Integer> answer,
    int sum
  ) {
    answer.add(candidates[index]);
    sum += candidates[index];
    if (sum > target) {
      answer.removeLast();
      return;
    }
    if (sum == target) {
      answers.add(new ArrayList<>(answer));
      answer.removeLast();
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      dfs(candidates, i, target, answers, answer, sum);
    }
    answer.removeLast();
  }

  public static void main(String[] args) {
    int[] candidates = { 2, 3, 6, 7 };
    int target = 7;
    CombinationSumPractice combinationSumPractice = new CombinationSumPractice();
    combinationSumPractice.combinationSum(candidates, target).forEach(System.out::println);
  }
}
