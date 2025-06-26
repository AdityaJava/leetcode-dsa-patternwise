package P5BFS.Q4PerfectSquares;

import java.util.Arrays;

//https://leetcode.com/problems/perfect-squares/description/
public class PerfectSquares {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return dfs(n, dp);
  }

  private int dfs(int remaining, int[] dp) {
    if (remaining == 0) {
      return 0;
    }
    if (dp[remaining] != -1) {
      return dp[remaining];
    }
    int minSteps = Integer.MAX_VALUE;
    for (int i = 1; (i * i) <= remaining; i++) {
      minSteps = Math.min(minSteps, dfs(remaining - i * i, dp) + 1);
    }
    dp[remaining] = minSteps;
    return dp[remaining];
  }

  public static void main(String[] args) {
    PerfectSquares perfectSquares = new PerfectSquares();
    System.out.println(perfectSquares.numSquares(12));
  }
}
