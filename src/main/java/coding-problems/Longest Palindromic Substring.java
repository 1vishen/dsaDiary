class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0, maxLenLeft = 0, maxLenRight = 0;
        for(int i = 0; i < s.length(); i++) {
            // palindrome can be even or odd length so we need to check both separately
            int lenEven = expandFromCenter(s, i, i);
            int lenOdd = expandFromCenter(s, i, i + 1);
            int currentLen = Math.max(lenEven, lenOdd);

            if(currentLen > maxLen) {
                maxLen = currentLen;
                maxLenLeft = i - (currentLen - 1) / 2; /* currentLen - 1 to handle both
                                                           and even since in even we have i
                                                            1 closer to left eg. abba i = 1 */
                maxLenRight = i + currentLen / 2;
            }
        }

        return s.substring(maxLenLeft, maxLenRight + 1); /* maxLenRight + 1 for substr 
                                                            upto maxLenRight */
    }

    public int expandFromCenter(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1; // -1 cause left and right already moved 1 place more
    }
}