package P6DynamicProgramming.MemoizationOrRecursion.Q4FrogJumWithKDistances;

public class FrogJumWithKDistances {
  public int frogJump(int[] heights, int k) {
    return dfs(heights, k, heights.length - 1);
  }

  private int dfs(int[] heights, int k, int currentStep) {
    if (currentStep == 0) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int i = k; i > 0; i--) {
      if ((currentStep - i) >= 0) {
        min = Math.min(Math.abs(heights[currentStep] - heights[currentStep - i]) + dfs(heights, k, currentStep - i), min);
      }
    }
    return min;
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
