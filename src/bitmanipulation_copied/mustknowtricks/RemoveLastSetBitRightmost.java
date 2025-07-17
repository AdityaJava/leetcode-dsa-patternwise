package bitmanipulation_copied.mustknowtricks;

/**
 * RemoveLastSetBitRightmost
 */
public class RemoveLastSetBitRightmost {
  //For 12 -> 1100 so if we remove last set bit (rightmost) it will become 1000 and this is 8
  public static int removeLastSetBit(int n) {
    return n & (n - 1);
  }

  public static void main(String[] args) {
    System.out.println(removeLastSetBit(12));
  }
}
