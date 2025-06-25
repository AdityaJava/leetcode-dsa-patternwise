package P6DynamicProgramming.TabulationOrLinear.Q4FrogJumWithKDistances;

public class FrogJumWithKDistances {
  public int frogJump(int[] heights, int k) {
    int[] dp = new int[heights.length];
    dp[0] = 0;
    for (int i = 1; i < heights.length; i++) {
      int minimumSteps = Integer.MAX_VALUE;
      for (int j = k; j > 0; j--) {
        if ((i - j) >= 0) {
          int jump = Math.abs(heights[i] - heights[i - j]) + dp[i - j];
          minimumSteps = Math.min(jump, minimumSteps);
        }
      }
      dp[i] = minimumSteps;
    }
    return dp[heights.length - 1];
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
