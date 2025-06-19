package DynamicProgramming.TabulationOrLinear.Q2ClimbingStairs;

public class ClimbingStairs {
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int[] dp = new int[n + 1];
    dp[1] = 1;  // 1 way to climb 1 stair
    dp[2] = 2;  // 2 ways to climb 2 stairs

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];  // Previous step + step before that
    }

    return dp[n];
  }

  public static void main(String[] args) {
    int n = 45;
    ClimbingStairs climbingStairs = new ClimbingStairs();
    System.out.println(climbingStairs.climbStairs(n));
  }
}
