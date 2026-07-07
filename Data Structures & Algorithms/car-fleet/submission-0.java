class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // a slower car can catch up to the faster car and thus form a fleet. And then, the speed of the slower car becomes equal to that of the faster car. So, I need to find the cars that can form a fleet or not.
        // I cannot start with the slower car as the faster cars might form fleets already.
        // so, start from the car closest to target and any car that's speed > prev car will never catch up and thus forms a new fleet. 
        // TC: O(n log n), SC: O(n)

        int n = position.length;
        int[][] cars = new int[n][2];

        for(int i=0; i<n; i++) // populating cars[][] with pos and speed
        {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> b[0] - a[0]); // sort descending based on the pos

        int fleet = 0; // final ans
        double slowestSpeed = 0.0; // track the slowest car

        for(int[] c : cars)
        {
            int pos = c[0];
            int spd = c[1];
            double time = (double) (target - pos)/spd; // time it takes to reach the target

            if(time > slowestSpeed) // it can never catch up and forms a new fleet
            {
                fleet++;
                slowestSpeed = time;
            }
        }
        return fleet;
    }
}