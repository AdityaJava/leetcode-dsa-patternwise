package P2SlidingWindow.Q2MinSubArrayLen;

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
