class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /* We need the slowest possible eating speed k that still lets Koko finish in h 
        hours. Higher k always makes finishing easier, so the feasibility is monotonic. 
        That's why we binary-search for the smallest k that keeps total eating 
        hours <= h. */

        /* first we need to know what max value of k is, thats max value in arr, 
        because at that speed koko can finish all other elements in arr most quick */
        int maxK = 0;
        for(int n : piles) {
            maxK = Math.max(maxK, n);
        }

        /* now we do binary search on k from 1 to maxK such that when added for all
        elements in arr its just <= h */
        int left = 1, right = maxK;
        int result = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long totalHours = totalHours(mid, piles, h);

            /* if totalHours <= h then that means that sol is valid try to find a 
            smaller working k on the left */
            if(totalHours <= h) {
                result = mid;
                right = mid - 1;
            }
            // if totalHours > h that means current k very slow need bigger k
            else if (totalHours > h) left = mid + 1;
        }
        return result;
    }

    public long totalHours(int k, int[] piles, int h) {
        long total = 0;
        for(int n : piles) {
            /* we do ceil here cause it number is decimal like 2.4 that means it will 
            take 3 tries cause we cant split number of tries it takes to eat */
            /* Math.ceil() is slow so we do :
            ceil(a / b) = (a + b - 1) / b  */
            total += ((long)n + k - 1) / k;
            // as soon as total hours exceed h, we can stop, speed k already fails.
            if(total > h) return total;
        }
        return total;
    }
}