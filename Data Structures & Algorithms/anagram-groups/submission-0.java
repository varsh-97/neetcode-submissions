class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // build freq[] for each str and check if it is equal to other str of same len
        // convert the freq[] to a str seperated by '#' as a key and the word as the value
        // return the value set from the hashmap
        // TC: O(w * L), SC: O(n)

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs)
        {
            char[] freq = new char[26];
            for(char c : s.toCharArray()) // building the freq[] for each string
            {
                freq[c - 'a']++; 
            }
            // convert the freq[] to a string
            StringBuilder sb = new StringBuilder();
            for(int count : freq)
            {
                sb.append(count).append('#');
            }
            // insert this unique hash to the map
            map.computeIfAbsent(sb.toString(), k->new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
