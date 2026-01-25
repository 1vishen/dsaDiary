class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * we dont have to make an arr otherwise you’re forced into
         * O(m+n) time because you have to touch every element. To achieve
         * O(log(m+n)), you have to find the median without actually
         * merging them
         */

        /*
         * PARTITION LOGIC (Binary Search on nums1)
         * Goal: Find 'i' such that L1 <= R2 and L2 <= R1
         * 
         * Split:
         * nums1: [ ... L1 | R1 ... ] (index i)
         * nums2: [ ... L2 | R2 ... ] (index j = (m+n+1)/2 - i)
         * 
         * Binary Search Moves:
         * - If L2 > R1: i is too small -> low = i + 1
         * - If L1 > R2: i is too large -> high = i - 1
         * 
         * Edge Case Values:
         * - Left empty: L = Integer.MIN_VALUE
         * - Right empty: R = Integer.MAX_VALUE
         * 
         * Median Result:
         * - Odd Total: max(L1, L2)
         * - Even Total: (max(L1, L2) + min(R1, R2)) / 2.0
         */

        /*
         * we are not actually sorting to get the final array, we are
         * just finding the midpoint of the final sorted array, and getting
         * only the numbers that will be compared around that midpoint. that
         * way we don’t need to compare all elements, we just need 4 values
         * a, b, c, d where a and b are from arr1 and c and d are from arr2
         * 
         * then we find a split such that the left elements (a, c) are
         * less than or equal to the right elements (b, d) of both arrays.
         * 
         * Think of it like this: If you have a total of 10 slots to fill on
         * the "Left Side," and you decide to take 3 from nums1, you must take
         * exactly 7 from nums2 to fill the remaining slots.
         */

        double median = -1;

        // make sure nums1 is smaller always
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        while (low <= high) {
            int mergedArrLeftPartFromSmallerArr = (low + high) / 2;
            /*
             * Why do we want the "Extra" element (+1) on the left?
             * If the total is odd, the median is just one single number. By
             * ensuring the left side is the larger one, we know for a fact that:
             * Median = max(L1, L2)
             * If we didn't use +1, the left side would be smaller, and the
             * median would be the smallest element of the right side
             * (min(R1, R2)). Standardizing it so the "extra" is always on the
             * left makes the code much cleaner.
             */
            int mergedArrLeftPartFromLargerArr = (m + n + 1) / 2 - mergedArrLeftPartFromSmallerArr;

            int i = mergedArrLeftPartFromSmallerArr;
            int j = mergedArrLeftPartFromLargerArr;

            /*
             * nums1[i - 1] < nums1[i] we know cause sorted
             * nums[i - 1] < nums2[j] we will know automatically if nums1[i - 1] < nums[j]
             * nums1[i - 1] < nums[j] and nums1[j - 1] < nums2[i] is what we want so its
             * opposite is what we dont want
             */

            // a (L1): The element to the left of the cut in nums1
            // If i is 0, there's no element at index -1, so use MIN_VALUE
            int a = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            // b (R1): The element at the cut in nums1
            // If i is m, there's no element at index m, so use MAX_VALUE
            int b = (i == m) ? Integer.MAX_VALUE : nums1[i];
            // c (L2): The element to the left of the cut in nums2
            int c = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            // d (R2): The element at the cut in nums2
            int d = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (a > d)
                high = i - 1;
            else if (c > b)
                low = i + 1;

            if ((m + n) % 2 != 0)
                median = Math.max(a, c);
            else if ((m + n) % 2 == 0)
                median = (double) (Math.max(a, c) + Math.min(b, d)) / 2;

            if (a <= d && c <= b)
                break;
        }

        return median;
    }
}
