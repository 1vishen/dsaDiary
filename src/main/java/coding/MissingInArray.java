class Solution {
    int missingNum(int arr[]) {
        // code here
        long l = arr.length + 1;
        long sum = (long) ((l * (l + 1)) / 2);
        long actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum = (long) actualSum + arr[i];
        }

        return (int) (sum - actualSum);

    }
}