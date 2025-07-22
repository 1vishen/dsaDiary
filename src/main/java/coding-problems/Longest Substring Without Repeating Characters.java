class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int startIndex = 0, maxLen = 0;

        for(int currentIndex = 0; currentIndex < s.length(); currentIndex++){
            char currentChar = s.charAt(currentIndex);
            //dup check
            while(seen.contains(currentChar)){
                seen.remove(s.charAt(startIndex));
                startIndex++;
            }
            seen.add(currentChar);
            maxLen = Math.max(maxLen, currentIndex - startIndex + 1);
        }
        return maxLen;

    }
}