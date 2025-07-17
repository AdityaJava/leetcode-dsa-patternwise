package bitmanipulation_copied.mustknowtricks;

/**
 * IthBitIsSet
 */
public class IthBitIsSet {

  //Time complexity is BIG-OH(1)

  // We are ANDING our number with 1 left shifted by 1 places
  // For Example number =13 binary = 1101   and now if i=2
  // Then we left shift 1 by 2 places so it becomes 0100
  // And now if suppose the bit is 1 then anding will return some value but if it is 0 then the anding will be zero
  public boolean isIthBitSetUsingLeftShift(int number, int i) {
    return ((number & (1 << i)) != 0);
  }

  public boolean isIthBitSetUsingRightShift(int number, int i) {
    return ((number >> i) & 1) != 0;
  }

  public static void main(String[] args) {
    IthBitIsSet ithBitIsSet = new IthBitIsSet();
    System.out.println(ithBitIsSet.isIthBitSetUsingLeftShift(4, 0));
    System.out.println(ithBitIsSet.isIthBitSetUsingRightShift(4, 0));
  }
}
