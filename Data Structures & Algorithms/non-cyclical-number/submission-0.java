class Solution {
    public boolean isHappy(int n) {
       // hare-tortoise method

       int slow = n;
       int fast = n;

       do
       {
          slow = findSquare(slow);
          fast = findSquare(findSquare(fast));
       } while(slow != fast);

       return slow == 1;
    }

    public int findSquare(int n)
    {
          int sum = 0;
          while(n>0)
          {
               int val = n % 10;
               sum += val * val;
               n = n/10;
          }
          return sum;
    }
}
