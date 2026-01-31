class Solution {
    public boolean isHappy(int n) {
        /*
         * we can use a set to track result of sum of sq of digits and if it duplicate
         * then we break and return and if we get 1 hten magic num
         */

        Set<Integer> resSet = new HashSet<>();

        while (true) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                n = n / 10;
                sum += digit * digit;
            }
            n = sum;
            if (resSet.contains(sum))
                return false;
            resSet.add(sum);
            if (sum == 1)
                return true;
        }
    }
}
