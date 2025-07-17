package bitmanipulation_copied.mustknowtricks;

/**
 * CountNumberOfSetBits
 */
public class CountNumberOfSetBits {

  // for 13 -> 1101 -> this should return 3
  public static int countNumberOfSetBits(int n) {
    int temp = n;
    int count = 0;
    while (temp != 1) {
      if (temp % 2 == 1) {
        count++;
      }
      temp = temp / 2;
    }
    if (temp == 1) {
      count++;
    }
    return count;
  }

  public static int countNumberOfSetBitsUsingBitWise(int n) {
    int temp = n;
    int count = 0;
    while (temp != 1) {
      //This works because of the fact that odd numbers will always have their last bit set to 1
      // Also below code can also be written as count = count + (temp&1)
      // as temp&1 will always return 1 if it is odd
      if ((temp & 1) != 0) {
        count++;
      }

      //As we know right shift means dividing by 2
      temp = temp >> 1;
    }
    if (temp == 1) {
      count++;
    }
    return count;
  }

  public static int countSetBitsUsingOnlyBitwise(int n) {
    int temp = n;
    int count = 0;
    while (temp != 0) {
      temp = temp & (temp - 1);
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countNumberOfSetBits(13));
    System.out.println(countNumberOfSetBitsUsingBitWise(13));
    System.out.println(countSetBitsUsingOnlyBitwise(13));
  }
}
