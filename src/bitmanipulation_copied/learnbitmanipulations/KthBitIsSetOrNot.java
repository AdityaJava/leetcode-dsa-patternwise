package bitmanipulation_copied.learnbitmanipulations;

import leetcode.bitmanipulation.mustknowtricks.IthBitIsSet;

/**
 * KthBitIsSetOrNot
 */
public class KthBitIsSetOrNot {
  static boolean checkKthBit(int n, int k) {
    String binary = toBinary(n);
    int bitFromLSB = binary.length() - k - 1;
    return binary.charAt(bitFromLSB) == '1';
  }

  static String toBinary(int n) {
    StringBuilder stringBuilder = new StringBuilder();
    int temp = n;
    while (temp != 1) {
      stringBuilder = stringBuilder.insert(0, temp % 2);
      temp = temp / 2;
    }
    stringBuilder.insert(0, temp);
    stringBuilder = appendZero(stringBuilder);
    return stringBuilder.toString();
  }

  static StringBuilder appendZero(StringBuilder binary) {
    int length = binary.length();
    for (; length < 32; length++) {
      binary.insert(0, '0');
    }
    return binary;
  }

  public static void main(String[] args) {
    System.out.println(checkKthBit(1250, 30));
    //More efficient and easy
    IthBitIsSet ithBitIsSet = new IthBitIsSet();
    System.out.println(ithBitIsSet.isIthBitSetUsingLeftShift(4, 0));
  }
}
