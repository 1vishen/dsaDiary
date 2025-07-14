class Solution {
    public int fib(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;

        List<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);

        for(int i = 2; i <= n; i++){
            int nextVal = fib.get(i - 1) + fib.get(i - 2);
            fib.add(nextVal);
        }

        return fib.get(n);

    }
}