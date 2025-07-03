class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int left = 0, right = arr.length - 1;

        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == k) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}