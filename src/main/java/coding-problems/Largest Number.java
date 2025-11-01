class Solution {
    public String largestNumber(int[] nums) {
        /* since numbers are very large we cant convert them to int and then compare

           also, since strings are same length we can use compareTo() since it
            compares lexicographically and that will be same as numberical 
            comparison for equal length strings 

           String.compareTo() returns an int, not a boolean.

           compareTo returns +ve if order2 > order1 (meaning b should come first)
        */

        /* converting to String[] to allow comparator based sorting, since comparator
            doesnt support primitives */
        String[] numsStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        // custom sort using Comparator<String> directly  
        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));

        // after decending sort if at index 0 we have 0 i.e. whole array is 0
        if(numsStr[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for(String s : numsStr) {
            result.append(s);
        }
        return result.toString();
    }
}