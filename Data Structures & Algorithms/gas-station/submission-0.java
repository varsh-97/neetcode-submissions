class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // greedy approach
        // first, we need to check if the totalgas will be sufficient for the entire loop.
        // It doesn't matter where we start, so, gain[i] = gas[i] - cost[i]. This total must be >= 0
        // for the starting point, we start from i and currentGas += gain. At some point j, if currentGas < 0, then
        // any point b/w i and j will not guarantee higher currentGas. That's why we reset start=j+1
        // and currentGas = 0.
        // TC: O(n), SC: O(1)

        int start = 0; // starting point
        int totalGas = 0; // total gains from each station
        int currGas = 0; // total gain from starting index until n-1

        for(int i=0; i<gas.length; i++)
        {
            int gain = gas[i] - cost[i]; // think of it as filling your tank and gas it takes to reach the next gas station
            totalGas += gain;
            currGas += gain;

            if(currGas < 0) // we can't even get to the next station
            {
                start = i+1; // everything b/w start and i would fail
                currGas = 0; // reset currGas
            }
        }
        return totalGas >= 0 ? start : -1;
    }
}
