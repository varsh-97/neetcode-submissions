class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
       // for each substring i = 0..n, check if that substring is a palindrome and add it to path
       // then, repeat for i+1..n 
       // build dp[][] to check if given substring is a palindrome
       // base case, if we reached end of string, return path
       // backtrack and try the next substring
       // TC: O(n^2) for dp[] and O(n . 2^n) for backtracking, SC: O(n^2 + n)

       int n = s.length();
       boolean dp[][] = new boolean[n][n];

       for(int i=0; i<n; i++)
       {
        for(int j=0; j<=i; j++)
        {
            if(s.charAt(j) == s.charAt(i) && (i-j <= 2 || dp[j+1][i-1]))
            {
                dp[j][i] = true;
            }
        }
       }

       backtrack(s, dp, 0, new ArrayList<>());
       return result;
    }

    public void backtrack(String s, boolean dp[][], int index, List<String> path)
    {
        if(index == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=index; i<s.length(); i++)
        {
            if(dp[index][i])
            {
                path.add(s.substring(index, i+1));
                backtrack(s, dp, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
}
