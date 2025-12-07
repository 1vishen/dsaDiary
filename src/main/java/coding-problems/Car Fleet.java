class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /* we dont need to track each car we need to know which car reached target 
        when i.e. time 
        If the car behind arrives sooner (less time), it gets stuck behind the 
        bottleneck. (Merge)
        If the car behind arrives later (more time), it becomes the new bottleneck 
        for everyone behind it. (New Fleet) */

        int n = position.length;

        // assigning cars their posn and speed before sorting
        int[][] car = new int[n][2];
        for (int i = 0; i < n; i++) {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        /* Because car is int[][] and Arrays.sort works on T[], each comparator 
        parameter (x, y) is one full row (int[]), not an index. */
        Arrays.sort(car, (x, y) -> Integer.compare(x[0], y[0]));

        //finding closest car posn that will act as wall
        int carWallPosn = car[n - 1][0];
        double carWallTime = (double) (target - carWallPosn) / car[n - 1][1];
        // starting with fleet = 1 cause 1st car chosen will be treated as 1 fleet
        int fleets = 1;

        if (n > 1) {
            // starting at n - 2 cause n - 1 is already initialized above
            for (int i = n - 2; i >= 0; i--) {
                int currPosn = car[i][0];
                double currTime = (double) (target - currPosn) / car[i][1];

                if (currTime > carWallTime) {
                    fleets++;
                    carWallTime = currTime;
                }
            }
        }
        return fleets;
    }
}