package DynamicProgramming.MemoizationOrRecursion.Q3FrogJump;

import java.util.Arrays;

//https://takeuforward.org/plus/dsa/problems/frog-jump
public class FrogJump {

  public int frogJump(int[] heights) {
    int[] minEnergyTillNow = new int[1];
    minEnergyTillNow[0] = Integer.MAX_VALUE;
    dfs(heights, 0, 0, 0, minEnergyTillNow);
    return minEnergyTillNow[0];
  }

  private int dfs(int[] heights, int energyConsumedTillNow, int currentStep, int energyNeeded, int[] minEnergyTillNow) {
    if (currentStep == heights.length - 1) {
      minEnergyTillNow[0] = Math.min(minEnergyTillNow[0], energyConsumedTillNow);
      return energyConsumedTillNow;
    }
    if ((currentStep + 1) < heights.length) {
      energyNeeded = Math.abs(heights[currentStep] - heights[currentStep + 1]);
      energyConsumedTillNow += energyNeeded;
      dfs(heights, energyConsumedTillNow, currentStep + 1, energyNeeded, minEnergyTillNow);
      energyConsumedTillNow -= energyNeeded;
    }
    if ((currentStep + 2) < heights.length) {
      energyNeeded = Math.abs(heights[currentStep] - heights[currentStep + 2]);
      energyConsumedTillNow += energyNeeded;
      dfs(heights, energyConsumedTillNow, currentStep + 2, energyNeeded, minEnergyTillNow);
      energyConsumedTillNow -= energyNeeded;
    }
    return energyConsumedTillNow;
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
