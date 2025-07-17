package P2SlidingWindow.Q1LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Q1LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int left = 0, right = 0;
    Set<Character> stringSet = new HashSet<>();
    int count = 0;
    int maxCount = 0;
    for (right = 0; right < s.length(); right++) {
      while (stringSet.contains(s.charAt(right))) {
        stringSet.remove(s.charAt(left));
        left++;
      }
      stringSet.add(s.charAt(right));
      count = right - left + 1;
      maxCount = Math.max(count, maxCount);
    }
    return maxCount;
  }

  public static void main(String[] args) {
    String s = "abcabcbb";
    Q1LengthOfLongestSubstring substring = new Q1LengthOfLongestSubstring();
    System.out.println(substring.lengthOfLongestSubstring(s));
  }
}
