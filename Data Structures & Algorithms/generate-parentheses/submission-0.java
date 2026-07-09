class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // backtracking: num of open == num of close
        // base case: open == 0 && close == 0
        // if open < close, skip

        int open = n;
        int close = n;

        dfs(open, close, new StringBuilder(), n);
        return result;
    }

    public void dfs(int open, int close, StringBuilder path, int n)
    {
        // base case
        if(open == 0 && close == 0)
        {
            result.add(new String(path));
            return;
        }

        if(open > 0)
        {
            path.append('(');
            dfs(open-1, close, path, n);
            path.deleteCharAt(path.length()-1);
        }

        if(close > open)
        {
            path.append(')');
            dfs(open, close-1, path, n);
            path.deleteCharAt(path.length()-1);
        }
    }
}
