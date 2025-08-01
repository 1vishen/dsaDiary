class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            long num = nums[i];
            if(num == max || num == max2 || num == max3) continue; 
            else if(max == Long.MIN_VALUE || num > max) {
                max3 = max2;
                max2 = max;
                max = num;
            }
            else if(max2 == Long.MIN_VALUE || num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if(max3 == Long.MIN_VALUE || num > max3) {
                max3 = num;
            }
        }
        return (int) (max3 != Long.MIN_VALUE ? max3 : max);
    }
}