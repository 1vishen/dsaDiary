class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] posn = new int[]{-1, -1};

        //for 1st occurance
        int minIndex = Integer.MAX_VALUE, maxIndex = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(target == nums[mid]) {
                    if(mid <= minIndex) {
                        posn[0] = mid;
                        minIndex = mid;
                        right = mid - 1; /* shrinking the array to make sure i get the 
                                            smallest index for 1st occurance, needed
                                            otherwise mid may not update and be stuck in 
                                            infinite loop    */
                    }

                }
                else if(target > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }

            //for last occurance
            minIndex = Integer.MAX_VALUE; 
            maxIndex = Integer.MIN_VALUE;
            left = 0; 
            right = nums.length - 1;

            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(target == nums[mid]) {
                    if(mid >= maxIndex) {
                        posn[1] = mid;
                        maxIndex = mid;
                        left = mid + 1; // same logic as before
                    }

                }
                else if(target > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }



        return posn;
    }
}