package P2SlidingWindow.Q3PermutationInString;

import java.util.HashMap;
//https://leetcode.com/problems/permutation-in-string/description/?envType=problem-list-v2&envId=sliding-window

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */

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
