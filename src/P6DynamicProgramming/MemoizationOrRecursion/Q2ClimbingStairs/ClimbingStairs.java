package P6DynamicProgramming.MemoizationOrRecursion.Q2ClimbingStairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClimbingStairs {
  public int climbStairs(int n) {
    List<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));
    return dfs(n, dp);
  }

  public int dfs(int n, List<Integer> dp) {
    if (n <= 1) {
      return 1;
    }
    if (dp.get(n) != -1) {
      return dp.get(n);
    }
    int left = dfs(n - 1, dp);
    int right = dfs(n - 2, dp);
    dp.set(n, left + right);
    return dp.get(n);
  }

  public static void main(String[] args) {
    int n = 45;
    ClimbingStairs climbingStairs = new ClimbingStairs();
    System.out.println(climbingStairs.climbStairs(n));
  }
}
