class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
         * okay so brute force will be pick each index 1 by 1 in cost and start from
         * there calc if gas >= cost till we finish and we will eventually find a
         * starting index which is sol
         */

        /*
         * If we start from station s and reach station k with tank < 0,
         * then none of the stations between s and k can be valid starts.
         * They weren’t enough to support the journey till k,
         * so we skip them and restart our check from k+1. circle is valid if and only
         * if the total amount of gas across all stations is at least the total cost.
         */

        int totalGas = 0, totalCost = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < cost.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                tank = 0;
                // forget everything before and start from i + 1 anew
                start = i + 1;
            }
        }

        if (totalGas < totalCost)
            return -1;
        // start will have last valid start if totalGas is enough for full round trip
        return start;
    }
}
