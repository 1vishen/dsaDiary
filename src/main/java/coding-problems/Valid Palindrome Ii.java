class Solution {
    public boolean validPalindrome(String s) {
        // only lowercase english letters so trim() and toLowerCase() not needed
        int ptr1 = 0, ptr2 = s.length() - 1;

        /* no = cause for even not needed and for odd only 1 char remains which is valid
         palindrome */
        while(ptr1 < ptr2) {
            if(s.charAt(ptr1) == s.charAt(ptr2)) {
                ptr1++;
                ptr2--;
            }  
            /* why we returned false just after 1st mismatch, it is because if we cant fix 
            even the 1st mismatch they it will never be a palindrome, and if it became a
            palindrome after skipping 1 char then we got our answer */
            else {
                if(isPdrome(s, ptr1 + 1, ptr2) || isPdrome(s, ptr1, ptr2 - 1))  return true;
                else return false;
            }
        }
        return true;
    }

    public boolean isPdrome(String t, int p1, int p2) {
        while(p1 < p2) {
            if(t.charAt(p1) != t.charAt(p2)) return false;
            else {
                p1++;
                p2--;
            }
        }
        return true;
    }
}
