package P1TwoPointers.Q1SquaresOfSortedArray;

import java.util.Arrays;

public class Q1SquaresOfSortedArray {
  public int[] sortedSquares(int[] nums) {
    int start = 0, end = nums.length - 1;
    int[] result = new int[nums.length];
    int resultPointer = result.length - 1;
    while (start <= end) {
      if (getSquare(nums[start]) > getSquare(nums[end])) {
        result[resultPointer--] = getSquare(nums[start]);
        start++;
      }
      else {
        result[resultPointer--] = getSquare(nums[end]);
        end--;
      }
    }
    return result;
  }

  private int getSquare(int number) {
    return number * number;
  }

  public static void main(String[] args) {
    int[] nums = { -7, -3, 2, 3, 11 };
    Q1SquaresOfSortedArray sortedArray = new Q1SquaresOfSortedArray();
    Arrays.stream(sortedArray.sortedSquares(nums)).forEach(System.out::println);
  }
}
