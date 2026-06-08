class Solution {
    public boolean isAnagram(String s, String t) {
        // build freq[] for s and t
        // iterate from i=0..26 and return false if s != t
        // TC: O(n), SC: O(1)

        if(s.length() != t.length()) return false;

        char[] freqS = new char[26];
        char[] freqT = new char[26];

        // building both freq[]
        for(int i=0; i<s.length(); i++)
        {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            freqS[sc - 'a']++;
            freqT[tc - 'a']++;
        }

        // iterate and compare
        for(int i=0; i<26; i++)
        {
            if(freqS[i] != freqT[i]) return false;
        }
        return true;
    }
}
