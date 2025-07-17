package bitmanipulation_copied.mustknowtricks;

/**
 * PowerOfTwo
 */
public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    return (n & (n - 1)) == 0;
  }

  public static void main(String[] args) {
    PowerOfTwo powerOfTwo = new PowerOfTwo();
    powerOfTwo.isPowerOfTwo(-2147483648);
  }
}
