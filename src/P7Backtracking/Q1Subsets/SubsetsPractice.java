package P7Backtracking.Q1Subsets;

import java.util.ArrayList;
import java.util.List;

// This generates all subsets (the power set) of the given array.
// Note: This includes all combinations of size 0 to n (i.e., C(n, 0) to C(n, n)).
// To generate combinations of a specific size k, add a condition: if (answer.size() == k).
public class SubsetsPractice {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> answers = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();
    dfs(nums, 0, answers, answer);
    return answers;
  }

  private void dfs(int[] nums, int index, List<List<Integer>> answers, List<Integer> answer) {
    answers.add(new ArrayList<>(answer));
    for (int i = index; i < nums.length; i++) {
      answer.add(nums[i]);
      dfs(nums, i + 1, answers, answer);
      answer.removeLast();
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    SubsetsPractice subsetsPractice = new SubsetsPractice();
    subsetsPractice.subsets(nums).forEach(System.out::println);
  }
}
