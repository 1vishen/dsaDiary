class Solution {
    public boolean repeatedSubstringPattern(String s) {
        /* the s + s trick checks for a self overlap. if a pattern exists, a 
        shifted copy of 's' will span the boundary of the two strings starting at 
        ending of 1st s and starting of 2nd s (starting at an index > 0 and < s.length
        ()). */

        String twiceS = s + s;
        /* removing 1st and last char so that search will not just find the 1st s itself
        and and the start of the second s */
        twiceS = twiceS.substring(1, twiceS.length() - 1);

        /* alternative brute force, linear substring search using a loop with 
        startsWith(prefix, index). This approach is typically O(N * L) complexity and
        slower than the built-in indexOf(). */
        return twiceS.indexOf(s) >= 0 ? true : false;
    }
}