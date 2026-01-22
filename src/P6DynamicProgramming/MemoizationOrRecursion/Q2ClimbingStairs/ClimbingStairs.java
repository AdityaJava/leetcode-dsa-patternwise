package P6DynamicProgramming.MemoizationOrRecursion.Q2ClimbingStairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/climbing-stairs/description/

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));
        int[] ans = new int[1];
        dfs2(0, dp, n);
        System.out.println(ans[0]);
        return dfs(n, dp);
    }

    public int dfs(int n, List<Integer> dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp.get(n) != -1) {
            return dp.get(n);
        }
        int left = dfs(n - 1, dp);
        int right = dfs(n - 2, dp);
        dp.set(n, left + right);
        return dp.get(n);
    }

    public int dfs2(int point, List<Integer> dp, int n) {
        if (point > n) {
            return 0;
        }
        if (point == n) {
            return 1;
        }
        if (dp.get(point) != -1) {
            return dp.get(point);
        }
        dp.set(point, dfs2(point + 1, dp, n)
                + dfs2(point + 2, dp, n));
        return dp.get(point);
    }

    public static void main(String[] args) {
        int n = 44;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(n));
    }
}
