class Solution {
    public int characterReplacement(String s, int k) {
        // len of the window - max freq of a char <= k, then we have a valid substring

        int[] freq = new int[26];
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            freq[c - 'A']++;

            int windowLen = right - left + 1;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            if(windowLen - maxFreq > k) // invalid window, shrink from left
            {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
