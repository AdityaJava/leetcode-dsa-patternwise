package bitmanipulation_copied.mustknowtricks;

/**
 * ClearIthBit
 */
public class ClearIthBit {
  public int clearIthBit(int n, int i) {
    return (n & ~(1 << i));
  }

  public static void main(String[] args) {
    ClearIthBit clearIthBit = new ClearIthBit();
    System.out.println(clearIthBit.clearIthBit(13, 2));
  }
}
