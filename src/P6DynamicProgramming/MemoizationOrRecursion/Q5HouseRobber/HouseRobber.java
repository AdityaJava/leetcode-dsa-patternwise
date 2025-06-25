package P6DynamicProgramming.MemoizationOrRecursion.Q5HouseRobber;

import java.util.Arrays;

public class HouseRobber {
  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return dfs(nums, nums.length - 1, dp);
  }

  private int dfs(int[] nums, int currentHouse, int[] dp) {
    if (currentHouse == 0) {
      return nums[0];
    }
    if (dp[currentHouse] != -1) {
      return dp[currentHouse];
    }
    int pick = nums[currentHouse];
    if ((currentHouse - 2) >= 0) {
      pick += dfs(nums, currentHouse - 2, dp);
    }
    int notPick = Integer.MIN_VALUE;
    if ((currentHouse - 1) >= 0) {
      notPick = dfs(nums, currentHouse - 1, dp);
    }
    dp[currentHouse] = Math.max(pick, notPick);
    return dp[currentHouse];
  }

  public static void main(String[] args) {
    int[] nums = { 2, 7, 9, 3, 1 };
    //    int[] nums = { 1, 2 };
    HouseRobber houseRobber = new HouseRobber();
    System.out.println(houseRobber.rob(nums));
  }
}
