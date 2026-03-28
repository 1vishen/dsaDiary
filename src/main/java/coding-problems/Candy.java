class Solution {
    public int candy(int[] ratings) {
        /*
         * a 2 pass method Give one candy to each child, then sweep left to right to
         * fix increasing ratings, and sweep right to left to fix decreasing ratings;
         * finally add them up.
         */

        int[] candy = new int[ratings.length];

        // give 1 candy to all
        for (int i = 0; i < candy.length; i++) {
            candy[i]++;
        }

        // from left to right
        for (int i = 0; i < ratings.length; i++) {
            if (i != ratings.length - 1) {
                if (ratings[i] < ratings[i + 1]) {
                    candy[i + 1] = candy[i] + 1;
                }
            }
        }

        // from right to left
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i != 0) {
                if (ratings[i] < ratings[i - 1]) {
                    /*
                     * use Math.max in second pass to preserve earlier counts; += would
                     * inflate values unnecessarily
                     */
                    candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);
                }
            }
        }

        // final count
        int candies = 0;
        for (int n : candy) {
            candies += n;
        }
        return candies;
    }
}
