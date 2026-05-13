class Solution {
    /*
     * System.arraycopy(src, srcPos, dest, destPos, length), It’s implemented
     * at the JVM level, so it can move chunks of memory directly, making it
     * much faster than manual loops. its not needed hin this Qs
     */
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int[] mergeSort(int[] arr, int l, int r) {
        // merge sort is divide and conquer
        /*
         * base condition : will be when we cant keep dividing further i.e. single
         * element arr we need to return that single element arr, since arr.length
         * never changes we can check length by l and r
         */
        if (l == r)
            return new int[] { arr[l] };

        /*
         * we need to break the arr in 2 parts and keep dividing it in both of
         * those parts
         */
        int mid = l + (r - l) / 2;
        /*
         * here since mid is different each time subsequent calls to mergeSort
         * will change l and r so arr will break into smaller pieces
         */
        int[] leftArr = mergeSort(arr, l, mid);
        int[] rightArr = mergeSort(arr, mid + 1, r);

        /*
         * now when we get back the leftArr and rightArr we need to sort them
         * and then merge them and that will be the result that mergeSort() outputs
         */
        /*
         * the first leftArr and rightArr we will get back is single element arr
         * and then more and more
         */
        return sort(leftArr, rightArr);
    }

    public int[] sort(int[] arr1, int[] arr2) {
        /*
         * here our objective is to sort first them merge then return thr result
         * this job is not to break problem in smaller parts so this sort() is not
         * recursive
         */
        int[] result = new int[arr1.length + arr2.length];

        // we will iterate through all 3 arr1, arr2, and result at the same time
        int r = 0, a1 = 0, a2 = 0;
        /*
         * r ptr will always increase since result arr needs an element everytime
         * but a1 and a2 will only increase if its respective element was added to
         * result
         */
        for (r = 0; r < result.length; r++) {
            if (a1 < arr1.length && a2 < arr2.length) {
                if (arr1[a1] < arr2[a2]) {
                    result[r] = arr1[a1];
                    a1++;
                } else {
                    result[r] = arr2[a2];
                    a2++;
                }
            } else
                break;
        }

        // if any of arr1, arr2 is still left we fill it in result arr
        while (a1 < arr1.length)
            result[r++] = arr1[a1++];
        while (a2 < arr2.length)
            result[r++] = arr2[a2++];

        return result;
    }
}
