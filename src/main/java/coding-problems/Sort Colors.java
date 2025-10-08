class Solution {
    public void sortColors(int[] nums) {
        // 1st pass: 3 counters to keep track of no. of 0,1,2 in the array
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                red++;
            else if (nums[i] == 1)
                white++;
            else
                blue++;
        }

        // 2nd pass: rewriting the array, assuming only valid input exist in array
        int i = 0;
        while (red > 0) {
            nums[i] = 0;
            red--;
            i++;
        }
        while (white > 0) {
            nums[i] = 1;
            white--;
            i++;
        }
        while (blue > 0) {
            nums[i] = 2;
            blue--;
            i++;
        }
    }
}