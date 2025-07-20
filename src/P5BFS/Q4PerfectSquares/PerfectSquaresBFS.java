package P5BFS.Q4PerfectSquares;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/perfect-squares/

public class PerfectSquaresBFS {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return bfs(0, n);
  }

  private int bfs(int sum, int n) {
    Queue<Integer> queue = new LinkedList<>();
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
          queue.add((j * j) + item);
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
