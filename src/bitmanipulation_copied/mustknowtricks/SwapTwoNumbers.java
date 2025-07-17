package bitmanipulation_copied.mustknowtricks;

/**
 * SwapTwoNumbers
 */
public class SwapTwoNumbers {
  //Here we will not use temp
  //We will solve it using XOR
  //  Rule for Bitwise XOR:
  //  If the corresponding bits are different, the result is 1.
  //  If the corresponding bits are the same, the result is 0.
  //So if we do 5 ^ 5 then it will be zero
  public static void swap(int a, int b) {
    a = a ^ b;
    b = a ^ b; //(substitute a as a^b) --> (a^b)^b  here b^b will get cancelled as it will be zero and b will be  a
    a = a ^ b; // substitute a as a^b and b as a -> (a^b) ^a -> b
    System.out.println("After swap a=" + a + " b=" + b);
  }

  public static void main(String[] args) {
    int a = 9, b = 10;
    System.out.println("Before swap a=" + a + " b=" + b);
    swap(a, b);
  }
}
