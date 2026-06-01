class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
         * we can use monotonic stack of increasing bars till we hit a bar lower
         * than current one then we know that the pattern can't extend past this and
         * so when we reach a shorter bar (break monotonic increasing pattern)we pop
         * till we find a bar which is even lower than the shorter bar we hit now
         */

        ArrayDeque<Integer> monoStack = new ArrayDeque<>();
        int maxArea = 0, width = 0, h = 0, lastIndex = 0;

        for (int i = 0; i < heights.length; i++) {
            if (monoStack.isEmpty() == true || heights[i] >= heights[monoStack.peek()])
                monoStack.push(i);
            else {
                while (monoStack.isEmpty() == false
                        && heights[i] < heights[monoStack.peek()]) {
                    int j = monoStack.pop();
                    /*
                     * width should be from 1 before i to 1 after monoStack.peek()
                     * formula for all inside [s,e] is e-s+1
                     */
                    /* we popped so stack could be empty so check is needed */
                    if (monoStack.isEmpty() == false)
                        width = (i - 1) - (monoStack.peek() + 1) + 1;
                    /*
                     * is stack is empty that means height at i is smallest so far
                     * and all before it were bigger than it so if its smallest it can
                     * make a rect from i to first index 0
                     */
                    else
                        width = i;
                    h = heights[j];
                    maxArea = Math.max(maxArea, (width * h));
                }
                // push current height index
                monoStack.push(i);
            }
        }

        /*
         * if stack is not empty in for loop that means all heights inside stack never
         * got any height shorter than themselves so in this case i will be last element
         */
        while (monoStack.isEmpty() == false) {
            int i = heights.length;
            int j = monoStack.pop();
            if (monoStack.isEmpty() == false)
                width = (i - 1) - (monoStack.peek() + 1) + 1;
            else
                width = i;
            h = heights[j];
            maxArea = Math.max(maxArea, (width * h));
        }

        return maxArea;

        /*
         * This problem is essentially a width calculation challenge because the height
         * is fixed for each bar.
         * 
         * 1. In an ideal "always increasing" scenario, the while loop never triggers
         * during the main iteration. The stack is processed at the end, where
         * the width is calculated as the distance between the total array length
         * and the index of the next smaller bar (the current stack top).
         * 
         * 2. In an "always decreasing" scenario, the while loop triggers constantly.
         * The stack is frequently emptied, meaning each bar's width is simply
         * calculated as 'i' because it can extend all the way back to the
         * start of the histogram.
         * 
         * 3. For all other cases, the logic operates between these two extremes,
         * using the stack to find the nearest smaller boundaries to the left
         * and right for every bar.
         */
    }
}
