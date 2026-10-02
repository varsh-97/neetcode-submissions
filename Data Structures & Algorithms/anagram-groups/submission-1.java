class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word : strs)
        {
            int[] freqMap = new int[26];

            for(char ch : word.toCharArray())
            {
                freqMap[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++)
            {
                sb.append(freqMap[i]).append('#');
            }

            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
