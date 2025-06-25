package P6DynamicProgramming.MemoizationOrRecursion.Q4FrogJumWithKDistances;

import java.util.Arrays;

public class FrogJumWithKDistances {
  public int frogJump(int[] heights, int k) {
    int[] dp = new int[heights.length];
    Arrays.fill(dp, -1);
    return dfs(heights, k, heights.length - 1, dp);
  }

  private int dfs(int[] heights, int k, int currentStep, int[] dp) {
    if (currentStep == 0) {
      return 0;
    }
    if (dp[currentStep] != -1) {
      return dp[currentStep];
    }
    int min = Integer.MAX_VALUE;
    for (int i = k; i > 0; i--) {
      if ((currentStep - i) >= 0) {
        min = Math.min(Math.abs(heights[currentStep] - heights[currentStep - i]) + dfs(heights, k, currentStep - i, dp), min);
      }
    }
    dp[currentStep] = min;
    return dp[currentStep];
  }

  public static void main(String[] args) {
    //    int[] heights = { 15, 4, 1, 14, 15 };
    //    int k = 3;

    int[] heights = { 10, 5, 20, 0, 15 };
    int k = 2;

    FrogJumWithKDistances frogJumWithKDistances = new FrogJumWithKDistances();
    System.out.println(frogJumWithKDistances.frogJump(heights, k));
  }
}
