package P6DynamicProgramming.MemoizationOrRecursion.Q3FrogJump;

import java.util.Arrays;

//https://takeuforward.org/plus/dsa/problems/frog-jump
public class FrogJump {

  public int frogJump(int[] heights) {
    int[] minEnergyTillNow = new int[1];
    minEnergyTillNow[0] = Integer.MAX_VALUE;
    int[] dp = new int[heights.length];
    Arrays.fill(dp, -1);
    //dfs(heights, 0, 0, minEnergyTillNow);
    return dp(heights, 0, dp);
  }

  private int dp(int[] heights, int currentStep, int[] dp) {
    if (currentStep == heights.length - 1) {
      return 0;
    }

    if (dp[currentStep] != -1) {
      return dp[currentStep];
    }

    int leftEnergy = Integer.MAX_VALUE, rightEnergy = Integer.MAX_VALUE;
    if (currentStep + 1 < (heights.length)) {
      leftEnergy = Math.abs(heights[currentStep] - heights[currentStep + 1]) + dp(heights, currentStep + 1, dp);
    }

    if (currentStep + 2 < (heights.length)) {
      rightEnergy = Math.abs(heights[currentStep] - heights[currentStep + 2]) + dp(heights, currentStep + 2, dp);
    }
    dp[currentStep] = Math.min(leftEnergy, rightEnergy);
    return dp[currentStep];
  }

  public static void main(String[] args) {
    int height[] = { 2, 1, 3, 5, 4 };
    int n = height.length;
    int dp[] = new int[n];
    Arrays.fill(dp, -1);
    FrogJump frogJump = new FrogJump();
    System.out.println(frogJump.frogJump(height));
  }
}
