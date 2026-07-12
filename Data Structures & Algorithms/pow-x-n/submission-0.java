class Solution {
    public double myPow(double x, int n) {
        // instead of multiplying a value n times which will be O(n), I can multiply it n/2 times and then, if n is even return res * res. Else, return x * res * res
        // Can be solved by both recursion and iteration. 
        // Recursion will be T: O(log N), S: O(log N). Iterative will be S: O(1)

        long N = n; // to avoid overflow for Integer.MIN_VALUE Eg: -24678934
        if(N < 0) // if n=-2, then we need to do 1/(x^2)
        {
            x = 1/x; 
            N = -N; // convert negative to positive
        }

        return fastPow(x, N);
    }

    public double fastPow(double x, long n)
    {
        // base case
        if(n == 0) return 1; // anything power 0 is 1

        double half = fastPow(x, n/2);

        if(n % 2 == 0) // if n is even
        {
            half *= half;
        }
        else
        {
            half *= half * x;
        }

        return half;
    }
}