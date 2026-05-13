class Solution {
    public boolean validDigit(int n, int x) {
        // we can dissect the digits and compare

        boolean flag = false;
        int digit = 0;
        while (n >= 10) {
            digit = n % 10;
            if (digit == x)
                flag = true;
            n = n / 10;
        }

        // checking first digit
        digit = n;
        if (digit != x && flag == true)
            return true;
        return false;
    }
}
