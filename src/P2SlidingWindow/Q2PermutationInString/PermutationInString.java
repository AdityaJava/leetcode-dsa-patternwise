package P2SlidingWindow.Q2PermutationInString;

import java.util.HashMap;

public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    HashMap<Character, Integer> s1Map = new HashMap<>();
    HashMap<Character, Integer> s2Map = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
    }

    int ptr = 0;
    for (ptr = 0; ptr < s2.length(); ptr++) {
      if (s1Map.containsKey(s2.charAt(ptr))) {
        break;
      }
    }
    if (ptr == s2.length()) {
      return false;
    }

    int left = ptr;
    int right = ptr;

    for (; right < s2.length(); right++) {
      if (s1Map.containsKey(s2.charAt(right))) {
        while (s2Map.get(s2.charAt(right)) > s1Map.get(s1.charAt(right))) {
          s2Map.put(s2.charAt(left), s2Map.get(s2.charAt(left)) - 1);
          left++;
        }
      }
      else {
        if (s1Map.equals(s2Map)) {
          return true;
        }
        s2Map.clear();
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //    String s1 = "ab", s2 = "eidbaooo";
    //
    String s1 = "ab", s2 = "eidboaoo";
    PermutationInString permutationInString = new PermutationInString();
    System.out.println(permutationInString.checkInclusion(s1, s2));
  }
}
