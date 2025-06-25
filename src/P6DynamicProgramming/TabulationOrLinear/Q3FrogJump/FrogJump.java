package P6DynamicProgramming.TabulationOrLinear.Q3FrogJump;

//https://takeuforward.org/plus/dsa/problems/frog-jump
public class FrogJump {
  public int frogJump(int[] heights) {
    int[] dp = new int[heights.length];
    dp[0] = 0;
    for (int i = 1; i < heights.length; i++) {
      int leftEnergy = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
      int rightEnergy = Integer.MAX_VALUE;
      if (i - 2 >= 0) {
        rightEnergy = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
      }
      dp[i] = Math.min(leftEnergy, rightEnergy);
    }
    return dp[heights.length - 1];
  }

  public int frogJumpSpaceOptimized(int[] heights) {
    int[] dp = new int[heights.length];
    dp[0] = 0;
    for (int i = 1; i < heights.length; i++) {
      int leftEnergy = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
      int rightEnergy = Integer.MAX_VALUE;
      if (i - 2 >= 0) {
        rightEnergy = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
      }
      dp[i] = Math.min(leftEnergy, rightEnergy);
    }
    return dp[heights.length - 1];
  }

  public static void main(String[] args) {
    int height[] = { 2, 1, 3, 5, 4 };
    FrogJump frogJump = new FrogJump();
    System.out.println(frogJump.frogJump(height));

  }
}
