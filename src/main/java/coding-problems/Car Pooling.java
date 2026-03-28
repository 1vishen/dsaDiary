class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
         * Each trip is split into two eventss: pickup (+passengers) at 'from' and
         * drop-off (-passengers) at 'to'. We store these eventss in a single array,
         * where
         * the sign (+/-) indicates add/remove passengers. Sorting eventss by location
         * lets
         * us traverse only actual events points, not every kilometer. While traversing,
         * we
         * track current passengers and check against capacity.
         */

        // building single events arr
        int[][] events = new int[2 * trips.length][2];
        int j = 0;
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            // add from, +passengers
            events[j][0] = trip[1];
            events[j][1] = +trip[0];
            j++;
            // add to, -passengers
            events[j][0] = trip[2];
            events[j][1] = -trip[0];
            j++;
        }

        // sorting events arr in asc
        Arrays.sort(events, (a, b) -> {
            /*
             * we need to handle the case where two eventss happen at the same location.
             * In that case, drop-offs (-passengers) should come before pickups
             * (+passengers)
             */
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            /*
             * this will work case -ve integers are always < +ve integers, so they will
             * come first
             */
            return Integer.compare(a[1], b[1]);
        });

        // main logic
        int currCapacity = 0;
        for (int[] event : events) {
            /*
             * the -/+ sign on event[1] will take care of changing capacity and since
             * we sorted removing passengers will always come before adding them
             */
            currCapacity += event[1];
            if (currCapacity > capacity)
                return false;
        }
        return true;
    }
}
