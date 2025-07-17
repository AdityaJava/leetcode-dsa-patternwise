package bitmanipulation_copied.mustknowtricks;

/**
 * ToggleIthBit
 */
public class ToggleIthBit {

  public static int toggleIthBit(int n, int i) {
    return (n ^ (1 << i));
  }

  public static void main(String[] args) {
    System.out.println(toggleIthBit(13, 2));
  }
}
