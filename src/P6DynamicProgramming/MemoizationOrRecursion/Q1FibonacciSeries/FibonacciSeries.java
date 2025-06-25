package P6DynamicProgramming.MemoizationOrRecursion.Q1FibonacciSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FibonacciSeries {

  // TC is O(N)
  // SC is O(N) Stack Space + O(N) Array
  private int fibonacci(int n, List<Integer> dp) {
    if (n <= 1) {
      return 1;
    }
    if (dp.get(n) != -1) {
      return dp.get(n);
    }
    dp.set(n, fibonacci(n - 1, dp) + fibonacci(n - 2, dp));
    return dp.get(n);
  }

  public static void main(String[] args) {
    int n = 5;
    FibonacciSeries fibonacciSeries = new FibonacciSeries();
    List<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));
    System.out.println(fibonacciSeries.fibonacci(n, dp));
  }
}
