package P6DynamicProgramming.TabulationOrLinear.Q1FibonacciSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FibonacciSeriesLinear {
  //TC = O(N)
  //SC = O(N)
  private int fibonacci(int n) {
    List<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));
    dp.set(0, 0);
    dp.set(1, 1);

    for (int i = 2; i <= n; i++) {
      dp.set(i, dp.get(i - 1) + dp.get(i - 2));
    }
    return dp.get(n);
  }

  public static void main(String[] args) {
    int n = 5;
    FibonacciSeriesLinear fibonacciSeriesLinear = new FibonacciSeriesLinear();
    System.out.println(fibonacciSeriesLinear.fibonacci(n));
  }
}
