package P2SlidingWindow.Q2PermutationInString;

import java.util.HashMap;

public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    HashMap<Character, Integer> s1Map = new HashMap<>();
    HashMap<Character, Integer> s2Map = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
    }

    int left = 0;
    int right = 0;
    for (right = 0; right < s2.length(); right++) {
      while (!s1Map.containsKey(s2.charAt(right))) {
        left++;
      }
    }

  }

  public static void main(String[] args) {

  }
}
