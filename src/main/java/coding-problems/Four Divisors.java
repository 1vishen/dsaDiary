class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            List<Integer> divisors = new ArrayList<>();
            int e = nums[i];

            for (int j = 1; j <= Math.sqrt(e); j++) {
                if (e % j == 0) {
                    // adding both pair of divisors
                    divisors.add(j);
                    // checking perfect sq before adding pairs, eg. 4*4=16
                    if (!divisors.contains(e / j))
                        divisors.add(e / j);
                }
            }

            if (divisors.size() == 4) {
                for (int n : divisors) {
                    sum += n;
                }
            }
        }
        return sum;
    }
}
