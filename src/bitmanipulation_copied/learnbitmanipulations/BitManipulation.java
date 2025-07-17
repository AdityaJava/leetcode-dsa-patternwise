package bitmanipulation_copied.learnbitmanipulations;

/**
 * BitManipulation
 */
public class BitManipulation {

  static void bitManipulation(int num, int i) {
    String binary = toBinary(num);
    int LSB = binary.length() - i;
    System.out.print(binary.charAt(LSB) + " ");
    StringBuilder stringBuilder = new StringBuilder(binary);
    stringBuilder.setCharAt(LSB, '1');
    System.out.print(binaryToDecimal(stringBuilder.toString()) + " ");

    stringBuilder.setCharAt(LSB, '0');
    System.out.print(binaryToDecimal(stringBuilder.toString()));
  }

  static String toBinary(int num) {
    int temp = num;
    String result = new String();
    while (temp != 1) {
      result = temp % 2 + result;
      temp = temp / 2;
    }
    result = temp + result;
    result = prefixZeros(result);
    return result;
  }

  static String prefixZeros(String binary) {
    int length = binary.length();
    for (; length < 32; length++) {
      binary = '0' + binary;
    }
    return binary;
  }

  static int binaryToDecimal(String binary) {
    int power = binary.length() - 1;
    int position = 0;
    return recursiveBinaryToDecimal(binary, position, power);
  }

  static int recursiveBinaryToDecimal(String binary, int position, int power) {
    if (position == (binary.length() - 1)) {
      return Integer.parseInt(String.valueOf(binary.charAt(position)));
    }
    int result = recursiveBinaryToDecimal(binary, position + 1, power - 1);
    int multiplier = Integer.parseInt(String.valueOf(binary.charAt(position)));
    if (multiplier == 1) {
      result = result + (int) Math.pow(2, power);
    }
    return result;
  }

  public static void main(String[] args) {
    BitManipulation.bitManipulation(446733544, 30);
  }
}
