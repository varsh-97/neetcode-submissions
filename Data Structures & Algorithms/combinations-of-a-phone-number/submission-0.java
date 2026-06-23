class Solution {
    // TC: O(4 ^ n), SC: O(h)
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0 || digits == null) return result;
        backtrack(digits,map, new StringBuilder(), 0);
        return result;
    }

    public void backtrack(String digits, String[] map, StringBuilder path, int index)
    {
        if(index == digits.length())
        {
            result.add(path.toString());
            return;
        }

        String values = map[digits.charAt(index) - '0']; // "abc"
        for(char c : values.toCharArray())
        {
            path.append(c);
            backtrack(digits, map, path, index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
