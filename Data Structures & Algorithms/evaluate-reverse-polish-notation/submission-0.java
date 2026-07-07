class Solution {
    public int evalRPN(String[] tokens) {
        // keep adding the numbers to the stack
       // when you come across an operator, pop the first 2 elements, evaluate using that operator and push the result back into stack
       // after reaching end of the input, pop()
       // TC: O(n), SC: O(n) 

        Stack<Integer> stack = new Stack<>();

        for(String c : tokens)
        {
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"))
            {
                int right = stack.pop();
                int left = stack.pop();

                if(c.equals("+"))
                {
                    stack.push(left + right);
                }
                else if(c.equals("*"))
                {
                    stack.push(left * right);
                }
                else if(c.equals("-"))
                {
                    stack.push(left - right);
                }
                else
                {
                    stack.push(left / right);
                }
            }
            else
            {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
