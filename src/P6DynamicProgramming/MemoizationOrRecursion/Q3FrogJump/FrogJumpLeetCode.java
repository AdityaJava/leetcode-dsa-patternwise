package P6DynamicProgramming.MemoizationOrRecursion.Q3FrogJump;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/frog-jump/description/
public class FrogJumpLeetCode {
  public boolean canCross(int[] stones) {
    Set<Integer> stoneSet = Arrays.stream(stones).boxed().collect(Collectors.toSet());
    return dfs(stoneSet, 1, stones[1], stones[stones.length - 1]);
  }

  private boolean dfs(Set<Integer> stoneSet, int stepCount, int currentStep, int lastStep) {
    if (currentStep == lastStep) {
      return true;
    }
    if ((stepCount - 1) > 0) {
      dfs(stoneSet, stepCount - 1, currentStep + (stepCount - 1), lastStep);
    }
    if (stoneSet.contains(currentStep + stepCount)) {
      dfs(stoneSet, stepCount, currentStep + stepCount, lastStep);
    }
    if (stoneSet.contains(currentStep + stepCount + 1)) {
      dfs(stoneSet, stepCount + 1, currentStep + stepCount + 1, lastStep);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
    FrogJumpLeetCode frogJumpLeetCode = new FrogJumpLeetCode();
    System.out.println(frogJumpLeetCode.canCross(stones));
  }

}
