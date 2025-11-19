class Solution {
    public int characterReplacement(String s, int k) {
        /* Expand while (window length - max frequency in window <= k) because that means the
        number of non‑dominant characters can be fixed with at most `k` replacements. 
        Shrink when (window length - max frequency in window > k). That inequality means the
        current window has too many mismatches we would need more than `k` replacements to make
        it uniform. */

        /* We don’t recalc maxFreq when shrinking. It may be stale, but that’s fine: it always
        corresponds to some valid window we’ve seen. The shrinking condition (windowLength -
        maxFreq > k) still ensures correctness, and avoiding recalculation keeps the
        algorithm O(n). This trick avoids 'expensive recalculations' and keeps the algorithm
        linear. */

        int backP = 0, frontP = 0;
        int[] freqArr = new int[26];
        int maxFreq = 0, maxLength = 0;
        int windowLength = 0;

        while (backP < s.length() && frontP < s.length()) {
            freqArr[s.charAt(frontP) - 'A']++;
            /* we dont need to calc maxFreq everytime we shrink the subarray cause 
            Stored maxFreq is always correct for at least one substring we’ve seen and we
            only want the largest valid substring length encountered. */
            maxFreq = Math.max(maxFreq, freqArr[s.charAt(frontP) - 'A']);
            // + 1 cause we both ptr are inclusive in length of substring
            windowLength = frontP - backP + 1;

            while((windowLength - maxFreq) > k) {
                // decreasing freq of char which leaves the window
                freqArr[s.charAt(backP) - 'A']--;
                backP++;
                windowLength = frontP - backP + 1;

            }
            /* Update maxLength after shrinking, so it reflects the length of the current
            valid window. */
            maxLength = Math.max(maxLength, windowLength);
            frontP++;
        }
        return maxLength;
    }
}
