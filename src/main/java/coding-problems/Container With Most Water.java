class Solution {
    public int maxArea(int[] height) {
        int leftP = 0, rightP = height.length - 1;
        int maxxArea = 0;

        while(leftP < rightP) {
            int minHeight = Math.min(height[leftP], height[rightP]);
            int newMaxxArea = minHeight * (rightP - leftP);
            if(newMaxxArea > maxxArea) {
                maxxArea = newMaxxArea;
            }
            if(height[leftP] <= height[rightP]) leftP++;
            else rightP--;
        }
        return maxxArea;
    }
}