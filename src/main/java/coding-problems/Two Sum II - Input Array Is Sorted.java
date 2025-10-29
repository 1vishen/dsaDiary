class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // constant space is needed
        int left = 0, right = numbers.length - 1;
        // no = cause we need 2 numbers not just 1
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            else if(numbers[left] + numbers[right] < target) left++;
            else right--;
        }
        return new int[]{};

    }
}