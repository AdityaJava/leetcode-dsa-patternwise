package bitmanipulation_copied.mustknowtricks;

/**
 * SetIthBit
 */
public class SetIthBit {

  public int setIthBit(int n, int i) {
    return ((1 << i) | n);
  }

  public static void main(String[] args) {
    SetIthBit setIthBit = new SetIthBit();
    System.out.println(setIthBit.setIthBit(13,1));
  }
}
