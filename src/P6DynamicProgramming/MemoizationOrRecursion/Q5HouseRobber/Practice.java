package P6DynamicProgramming.MemoizationOrRecursion.Q5HouseRobber;

import java.util.Arrays;


public class Practice {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(dfs(i, nums, dp), max);
        }
        return max;
    }

    private int dfs(int index, int[] nums, int[] dp) {
        if (dp[index] != -1) {
            return dp[index];
        }
        int maxTillNow = 0;
        for (int i = index + 2; i < nums.length; i++) {
            maxTillNow = Math.max(dfs(i, nums, dp), maxTillNow);
        }
        dp[index] = nums[index] + maxTillNow;
        return dp[index];
    }

    public static void main(String[] args) {

    }

}
