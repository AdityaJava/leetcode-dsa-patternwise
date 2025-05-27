package P3FastAndSlowPointers.Q2HappyNumber;

public class HappyNumber {
  public boolean isHappy(int n) {
    int fast = squareEachDigit(n), slow = n;
    while (fast != 1 && fast != slow) {
      slow = squareEachDigit(slow);
      fast = squareEachDigit(squareEachDigit(fast));
    }
    return fast == 1;
  }

  private int squareEachDigit(int n) {
    int sum = 0;
    while (n != 0) {
      int remainder = n % 10;
      sum += remainder * remainder;
      n = n / 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    HappyNumber happyNumber = new HappyNumber();
    System.out.println(happyNumber.isHappy(2));
  }
}
