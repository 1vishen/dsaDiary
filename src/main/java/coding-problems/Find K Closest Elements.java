class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /* This version skips finding a single closest index and instead shrinks the full 
        window until size == k. It avoids extra binary search + shrinking logic, making the 
        code shorter and simpler while still optimal. */

        int left = 0, right = arr.length - 1;

        /* loop shrinks arr by 1 each time till right - left + 1 = k */
        while(right - left + 1 > k) {
            int mid = left + (right - left) / 2;
            /* (Math.abs(x - arr[left]) > Math.abs(x - arr[right])), this means arr[left]
            is less closer to x and hence to be removed */
            if((Math.abs(x - arr[left]) > Math.abs(x - arr[right]))) left++;
            else right--;
        }

        List<Integer> result = new ArrayList<>();
        // both left, right are inclusive
        for(int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
