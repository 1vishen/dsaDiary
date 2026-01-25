class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        // we can use a method that gives binary representation of an integer.
        for (int i = 0; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            /*
             * To represent a number n, you need enough bits so that:
             * 2^k>n Solving for k: k>\log _2(n) so tc is O(n log n) and not O(n²)
             */
            int countOfOnes = countOnes(binary);
            ans[i] = countOfOnes;
        }
        return ans;
    }

    public int countOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        return count;
    }
}
