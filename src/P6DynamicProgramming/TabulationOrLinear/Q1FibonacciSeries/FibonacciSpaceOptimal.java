package P6DynamicProgramming.TabulationOrLinear.Q1FibonacciSeries;

public class FibonacciSpaceOptimal {
  private int fibonacciOptimal(int n) {
    int prev1 = 0, prev2 = 1;
    for (int i = 2; i <= n; i++) {
      int sum = prev1 + prev2;
      prev1 = prev2;
      prev2 = sum;
    }
    return prev2;
  }

  public static void main(String[] args) {
    int n = 6;
    FibonacciSpaceOptimal fibonacciSpaceOptimal = new FibonacciSpaceOptimal();
    System.out.println(fibonacciSpaceOptimal.fibonacciOptimal(n));
  }
}
