/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        /*
         * problem is interactive cause i cant directly access the arr and
         * must use provided methods only, i will first find the peak then
         * i can apply binary search efficiently in the side our target is
         */

        /*
         * Peak finding (search for maximum/minimum in a monotonic structure):
         * use while (left < right) → loop converges to one index.
         */
        int peak = 0;
        int left = 0, right = mountainArr.length() - 1;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                left = mid + 1;
            /* not right = mid + 1 cause mid can still be peak */
            else
                right = mid;
        }
        peak = left;

        // by definition of mountain arr, we hav asc first and desc second
        int index = binarySearch(mountainArr, 0, peak, target, 'A');
        if (index != -1)
            return index;

        index = binarySearch(mountainArr, peak, mountainArr.length() - 1, target,
                'D');
        if (index != -1)
            return index;
        else
            return -1;
    }

    private int binarySearch(MountainArray arr, int left, int right, int target,
            char order) {
        /*
         * Binary search (search for exact target): use while (left <= right) →
         * ensures all indices are considered.
         */
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // storing result in var cause arr.get() is expensive
            int val = arr.get(mid);

            if (val == target)
                return mid;
            else if (order == 'A') {
                if (val > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (order == 'D') {
                if (val > target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
