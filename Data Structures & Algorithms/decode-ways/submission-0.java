class Solution {
    public int numDecodings(String s) {
        // at each index, check if that num is valid and if that num can be combined with the
        // prev number to form a valid 2 digit num b/w 10-26
        // TC: O(n), SC: O(1)

    if(s == null || s.length() == 0) return 0;

    int prev2 = 1; // there is only 1 way to decode an empty string
    int prev1 = s.charAt(0) == '0' ? 0 : 1;

    for(int i=1; i<s.length(); i++)
    {
        int curr = 0;
        if(s.charAt(i) != '0')
        {
            curr += prev1;
        }

        if(isValid(i-1, i, s))
        {
            curr += prev2;
        }

        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
    }

    public boolean isValid(int start, int end, String s)
    {
        int num = ((s.charAt(start) - '0') * 10) + (s.charAt(end) - '0');
        return (num >= 10 && num <= 26);
    }
}
