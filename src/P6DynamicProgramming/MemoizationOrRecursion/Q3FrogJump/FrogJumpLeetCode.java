package P6DynamicProgramming.MemoizationOrRecursion.Q3FrogJump;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/frog-jump/description/
public class FrogJumpLeetCode {
  public boolean canCross(int[] stones) {
    if (stones.length == 2) {
      if (stones[0] + 1 == stones[1]) {
        return true;
      }
      return false;
    }
    Set<Integer> stoneSet = Arrays.stream(stones).boxed().collect(Collectors.toSet());
    Map<String, Boolean> dp = new HashMap<>();
    return dfs(stoneSet, 1, stones[1], stones[stones.length - 1], dp);
  }

  private boolean dfs(Set<Integer> stoneSet, int stepCount, int currentStep, int lastStep, Map<String, Boolean> dp) {
    String key = stepCount + "" + currentStep;
    if (currentStep == lastStep) {
      return true;
    }
    boolean result = false;
    if ((stepCount - 1) > 0 && stoneSet.contains(currentStep + (stepCount - 1))) {
      result = dfs(stoneSet, stepCount - 1, currentStep + (stepCount - 1), lastStep, dp);
      if (result) {
        return true;
      }
    }
    if (stoneSet.contains(currentStep + stepCount)) {
      result = dfs(stoneSet, stepCount, currentStep + stepCount, lastStep, dp);
      if (result) {
        return true;
      }
    }
    if (stoneSet.contains(currentStep + stepCount + 1)) {
      result = dfs(stoneSet, stepCount + 1, currentStep + stepCount + 1, lastStep, dp);
      if (result) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //    int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
    int[] stones = { 0, 2 };
    FrogJumpLeetCode frogJumpLeetCode = new FrogJumpLeetCode();
    System.out.println(frogJumpLeetCode.canCross(stones));
  }

}
