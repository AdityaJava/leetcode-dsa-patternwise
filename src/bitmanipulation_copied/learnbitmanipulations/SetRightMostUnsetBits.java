package bitmanipulation_copied.learnbitmanipulations;

/**
 * SetRightMostUnsetBits
 */
public class SetRightMostUnsetBits {
  static int setBit(int n) {
    n = n | (n + 1);
    return n;
  }

  public static void main(String[] args) {
    System.out.println(setBit(13));
  }
}
