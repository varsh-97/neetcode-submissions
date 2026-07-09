class Solution {
    public boolean isValid(String s) {
        // for every open bracket, push it's corresponding close bracket to stack
        // and for every close bracket, pop() and if they don't match, return false
        // TC: O(n), SC: O(n)

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c == '[') stack.push(']');
            else if (c == '(') stack.push(')'); 
            else if(c == '{') stack.push('}');

            else
            {
                if(stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty() ? true : false; 
    }
}
