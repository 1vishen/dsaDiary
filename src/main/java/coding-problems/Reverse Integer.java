class Solution {
    public int reverse(int x) {
        int y = x;
        int rev = 0;
        while (y != 0){
            int digit = y % 10;
            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) return 0;
            rev = rev * 10 + digit;
            y = y / 10;
        } 
        return rev;
    }
}