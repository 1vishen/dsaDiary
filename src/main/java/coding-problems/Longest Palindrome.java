class Solution {
    public int longestPalindrome(String s) {
        int[] freqMap = new int[128]; //65-90 97-122 a-z A-Z
        for(char ch : s.toCharArray()) {
            frxeqMap[ch]++;
        }

        int longest = 0;
        for(int num : freqMap) {
            longest = longest + (num / 2) * 2;
        }

        if(longest < s.length()) { //this means we still have chars in string left but each have only 1 freq so we can add 1 of them in the middle
        longest += 1;

        }
        return longest;
    }
}