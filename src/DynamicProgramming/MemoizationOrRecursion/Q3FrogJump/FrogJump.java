package DynamicProgramming.MemoizationOrRecursion.Q3FrogJump;

import java.util.Arrays;

//https://takeuforward.org/plus/dsa/problems/frog-jump
public class FrogJump {

  public int frogJump(int[] heights) {
    return dfs(heights, 0, 0, 0);
  }

  private int dfs(int[] heights, int energyConsumedTillNow, int currentStep, int energyNeeded) {
    if (currentStep == heights.length - 1) {
      energyConsumedTillNow += Math.abs(heights[currentStep] - energyNeeded);
      return energyConsumedTillNow;
    }
    int leftEnergyNeeded = 0, rightEnergyNeeded = 0;
    if ((currentStep + 1) < heights.length) {
      energyNeeded = Math.abs(heights[currentStep] - heights[currentStep + 1]);
      leftEnergyNeeded = dfs(heights, energyConsumedTillNow, currentStep + 1, energyNeeded);
    }
    if ((currentStep + 2) < heights.length) {
      energyNeeded = Math.abs(heights[currentStep] - heights[currentStep + 2]);
      rightEnergyNeeded = dfs(heights, energyConsumedTillNow, currentStep + 2, energyNeeded);
    }
    return Math.min(leftEnergyNeeded, rightEnergyNeeded);
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
