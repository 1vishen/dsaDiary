class Solution {
    public boolean isPalindrome(int x) {
        int y = x;
        int rev = 0;
        if(y < 0) return false;

        while (y != 0) {
            int digit = y % 10;
            rev = rev * 10 + digit;
            y = y / 10; 
        }

        if(rev == x) return true;
        else return false;
    }
}