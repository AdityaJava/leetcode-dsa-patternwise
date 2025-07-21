package P5BFS.Q4PerfectSquares;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/perfect-squares/

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquaresBFS {
  public int numSquares(int n) {
    return bfs(0, n);
  }

  private int bfs(int sum, int n) {
    Queue<Integer> queue = new LinkedList<>();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 0);
    queue.add(sum);
    int height = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      height++;
      for (int i = 0; i < size; i++) {
        int item = queue.poll();
        for (int j = 1; ((j * j) + item) <= n; j++) {
          if ((j * j) + item == n) {
            return height;
          }

          // Since BFS explores level by level, if we reach '9' at a lower level (shorter path), we skip any later occurrences of '9'.
          // For example, if we reach '9' at level 2, we won’t revisit it at level 4 as we already found the shorter path.
          if (dp[(j * j) + item] == 0) {
            dp[(j * j) + item] = 1;
            queue.add((j * j) + item);
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int n = 12;
    PerfectSquaresBFS perfectSquaresBFS = new PerfectSquaresBFS();
    System.out.println(perfectSquaresBFS.numSquares(n));
  }
}
