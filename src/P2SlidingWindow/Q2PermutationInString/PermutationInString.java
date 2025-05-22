package P2SlidingWindow.Q2PermutationInString;

import java.util.HashMap;

public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    HashMap<Character, Integer> s1Map = new HashMap<>();
    HashMap<Character, Integer> s2Map = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
    }
    int windowSize = s1.length();
    HashMap<Character, Integer> window = new HashMap<>();
    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      window.put(c, window.getOrDefault(c, 0) + 1);

      if (i >= windowSize) {
        char leftChar = s2.charAt(i - windowSize);
        if (window.get(leftChar) == 1) {
          window.remove(leftChar);
        }
        else {
          window.put(leftChar, window.get(leftChar) - 1);
        }
      }
      if (s1Map.equals(window)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //    String s1 = "ab", s2 = "eidbaooo";
    //
    //        String s1 = "ab", s2 = "eidboaoo";
    //    String s1 = "adc", s2 = "dcda";

    String s1 = "abc", s2 = "cccccbabbbaaaa";

    PermutationInString permutationInString = new PermutationInString();
    System.out.println(permutationInString.checkInclusion(s1, s2));
  }
}
