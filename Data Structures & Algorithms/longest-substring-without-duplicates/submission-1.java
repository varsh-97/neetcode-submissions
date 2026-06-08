class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use hashMap + sliding window to track unique chars and max window Len
        // TC: O(n), SC: O(n)

        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            if(map.containsKey(c)) // shrink the window and update key in map
            {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
