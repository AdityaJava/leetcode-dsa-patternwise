package P6DynamicProgramming.MemoizationOrRecursion.Q2ClimbingStairs;

public class ClimbingStairsRevision {
  int ways = 0;

  public int climbStairs(int n) {
    dfs(0, n);
    return ways;
  }

  private void dfs(int step, int n) {
    if (step == n) {
      ways++;
      return;
    }
    if ((step + 1) <= n) {
      dfs(step + 1, n);
    }
    if ((step + 2) <= n) {
      dfs(step + 2, n);
    }
  }

  public static void main(String[] args) {
    int n = 3;
    ClimbingStairsRevision climbingStairsRevision = new ClimbingStairsRevision();
    System.out.println(climbingStairsRevision.climbStairs(n));
  }
}
