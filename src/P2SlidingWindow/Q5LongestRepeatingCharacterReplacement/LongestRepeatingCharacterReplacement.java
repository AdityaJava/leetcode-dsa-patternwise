package P2SlidingWindow.Q5LongestRepeatingCharacterReplacement;

//Not working
public class LongestRepeatingCharacterReplacement {
  public int characterReplacement(String s, int k) {
    int left = 0;
    int right = 0;
    int[] chars = new int[26];
    int maxFrequency = Integer.MIN_VALUE;
    int numberOfCharsNeedsToReplace = 0;
    int longestRepeatingString = 0;
    for (right = 0; right < s.length(); right++) {
      chars[s.charAt(right) - 'A']++;
      maxFrequency = Math.max(maxFrequency, chars[s.charAt(right) - 'A']);
      numberOfCharsNeedsToReplace = (right - left + 1) - maxFrequency;
      while (numberOfCharsNeedsToReplace > k) {
        numberOfCharsNeedsToReplace = (right - left + 1) - maxFrequency;
        chars[s.charAt(left) - 'A']--;
        left++;
      }
      longestRepeatingString = Math.max(longestRepeatingString, (right - left + 1));

    }
    return longestRepeatingString;
  }

  public static void main(String[] args) {
    //    String s = "AABABBA";
    //    int k = 1;

    String s = "BAAA";
    int k = 0;

    LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
    System.out.println(longestRepeatingCharacterReplacement.characterReplacement(s, k));
  }
}
