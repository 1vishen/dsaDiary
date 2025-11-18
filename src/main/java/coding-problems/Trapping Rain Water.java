class Solution {
    public int trap(int[] height) {
        /* One approach is Precompute maxLeft[] and maxRight[] arrays, precompute approach its
        kinda like prefix sum questions, here we will use 2 ptr approach: */
        /* Use two pointers (left, right) and track leftMax, rightMax (these are max heights 
        encountered thus far). Always move the smaller side because its max determines trapped 
        water. If heights are equal, move either pointer (commonly left++) */

        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int waterTrapped = 0;

        /* we need = cause we need to know how much water the last ptr can store in case
        of odd numbers */
        while(left <= right) {
            if(height[left] < height[right]) {
                /* if height[left] is bigger than maxLeft then no water can be trapped and
                we need to update maxLeft but if height[left] is smaller then we calc 
                water trapped by sub maxLeft - height[left] cause at ANY POINT THE WATER 
                TRAPPED IS LIMITED BY BOUNDARIES ON EITHER SIDE AND EVEN AMONG THOSE BOUNDARIES
                THE SMALLER OF THOSE 2 GOVERNS HOW MUCH WATER WILL BE STORED AT THE CURRENT
                POINT, same for maxRight */
                if(height[left] >= maxLeft) maxLeft = height[left];
                else {
                    waterTrapped += maxLeft - height[left];
                }
                left++;
            }
            /* when height[left] == height[right] we can move either ptr it doesnt matter */
            else if(height[left] >= height[right]) {
                if(height[right] >= maxRight) maxRight = height[right];
                else {
                    waterTrapped += maxRight - height[right];
                }
                right--; 
            }
        }
        return waterTrapped;
    }
}