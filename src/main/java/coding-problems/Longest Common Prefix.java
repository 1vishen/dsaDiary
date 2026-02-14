class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        String longestCommon = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(longestCommon)) {
                if (longestCommon.length() == 0)
                    return "";
                longestCommon = longestCommon.substring(0, longestCommon.length() - 1);
            }
        }
        return longestCommon;
    }
}