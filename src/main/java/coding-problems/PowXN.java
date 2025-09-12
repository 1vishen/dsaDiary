class Solution {
    public double myPow(double x, int n) {
        long N = n;

        //when n is +ve/-ve, so that p is always +ve in helper
        if(N < 0) return 1 / helper(x, -N);
        else return helper(x, N);
    }

    private double helper(double x, long p) {
        /* x^13 = x^8 * x^4 * x^1
            for even, x^n = (x^2)^{n/2} = (x^n/2)*(x^n/2) square the base and 
            halve the exponent.
            for odd,  x^n = x * (x^2)^{(n-1)/2} reduce the exponent by 1 (making it even),
            then apply the even rule. */

        //base case
        if(p == 0) return 1;

        //recursive case
        double half = helper(x, p / 2);
        if(p % 2 == 0) return half * half;
        else return half * half * x;
    }
}