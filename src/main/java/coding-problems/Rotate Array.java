class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // cause only the remainder will matter k == 0 and k == n will not change the array
        if(k > n) k = k % n;
        if(k == 0 || k == n || k < 0) return;

        // reverse entire array
        reverse(nums, 0, n - 1);
        // then reverse 1st k elements only
        reverse(nums, 0, k - 1);
        // then reverse the rest excluding 1st k
        reverse(nums, k, n - 1);
    }

    // code to reverse elements from start to end both indexes inclusive
    public void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}