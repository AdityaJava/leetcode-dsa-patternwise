package bitmanipulation_copied.practice;

/**
 * CountSetBits
 */
public class CountSetBits {

  public static int countSetBits(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      int temp = i;
      if ((temp & 1) != 0) {

      }
      while (temp != 0) {
        temp = temp & (temp - 1);
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countSetBits(4));
  }
}
