package P6DynamicProgramming.TabulationOrLinear.Q5HouseRobber;

import java.util.Arrays;

public class HouseRobber {
  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int pick = nums[i];
      if ((i - 2) >= 0) {
        pick += dp[i - 2];
      }
      int notPick = Integer.MIN_VALUE;
      if ((i - 1) >= 0) {
        notPick = dp[i - 1];
      }
      dp[i] = Math.max(pick, notPick);
    }
    return dp[nums.length - 1];
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 1 };
    //    int[] nums = { 1, 2 };
    HouseRobber houseRobber = new HouseRobber();
    System.out.println(houseRobber.rob(nums));
  }
}
