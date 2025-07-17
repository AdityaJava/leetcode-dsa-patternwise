package P2SlidingWindow.Q2MinSubArrayLen;


//https://leetcode.com/problems/minimum-size-subarray-sum/description/

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class MinSubArrayLen {
  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int right = 0;
    int minSize = Integer.MAX_VALUE;
    int sum = 0;
    for (right = 0; right < nums.length; right++) {
      sum = sum + nums[right];
      while (sum >= target) {
        minSize = Math.min(minSize, (right - left + 1));
        sum = sum - nums[left];
        left++;
      }
    }
    return minSize != Integer.MAX_VALUE ? minSize : 0;
  }

  public static void main(String[] args) {
    //    int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1 };
    //    int target = 11;
    //
    int[] nums = { 1, 2, 3, 4, 5 };
    int target = 11;

    //    int[] nums = { 2, 3, 1, 2, 4, 3 };
    //    int target = 7;

    MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
    System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
  }
}
