class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int max = -1, sMax = -1;
        for (int num : arr) {
            if (num > max) {
                sMax = max;
                max = num;
            } else if (num < max && num > sMax) {
                sMax = num;
            }
        }
        return sMax;
    }
}