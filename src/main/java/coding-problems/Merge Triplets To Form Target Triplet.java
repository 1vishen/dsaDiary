class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        /*
         * since max will select bigger val, we just need to pick 1 posn at a time
         * and iterate through triplets arr to check if any match exists and we do this
         * 3 times for all 3 posn of triplets
         */

        int foundX = 0, foundY = 0, foundZ = 0;
        for (int i = 0; i < triplets.length; i++) {
            // when i = 1 it check at 1 posn and so on
            int[] t = triplets[i];

            /*
             * this ensures that only triplets with values lower than or equal to target
             * pass
             */
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;

            if (t[0] == target[0])
                foundX = 1;
            if (t[1] == target[1])
                foundY = 1;
            if (t[2] == target[2])
                foundZ = 1;
        }

        if (foundX == 1 && foundY == 1 && foundZ == 1)
            return true;
        return false;
    }
}
