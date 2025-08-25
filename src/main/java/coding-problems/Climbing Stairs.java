class Solution {
    public int climbStairs(int n) {
        // to reach nth step we can do it in n - 1 or n - 2, basically fibo(n)

        // recursive
        // if(n == 1) return 1;
        // if(n == 0) return 1;
        // return climbStairs(n - 1) + climbStairs(n - 2);

        if(n == 0 || n == 1) return 1; //0 for both cause 1 way to do both steps

        int a = 1, b = 1; //step(0) and step(1)

        for(int i = 2; i <= n; i++) {
            int fib = a + b;
            a = b;
            b = fib;
        }
        return b;
    }
}