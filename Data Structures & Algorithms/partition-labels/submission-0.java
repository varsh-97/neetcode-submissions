class Solution {
    public List<Integer> partitionLabels(String s) {
        // iterate over s and find the ending index for each char and store it in freq[26]
        // ieterate over s and for i = 0..s.length(), for each i, find the last index and fix it as right
        // move this right to the latest largest end based on freq[] and add it to the result.
        // TC: O(n), SC: O(1)

        int[] last = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            int idx = s.charAt(i) - 'a';
            last[idx] = i; // stores the last index of that char
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++)
        {
            int idx = s.charAt(i) - 'a';
            end = Math.max(end, last[idx]); 

            if(i == end)
            {
                result.add(end - start + 1); // len of partition
                start = i+1; // next partition starting
            }
        }
        return result;
    }
}
