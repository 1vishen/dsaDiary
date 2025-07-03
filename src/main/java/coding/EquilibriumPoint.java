class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int sumAfterI = 0, sumbeforeI = 0;
        for (int num : arr) {
            sumAfterI += num;
        }
        for (int i = 0; i < arr.length; i++) {

            sumAfterI -= arr[i];
            if (sumbeforeI == sumAfterI)
                return i;
            sumbeforeI += arr[i];
        }
        return -1;
    }
}