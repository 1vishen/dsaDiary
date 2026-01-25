class Solution {
    public String minWindow(String s, String t) {
        // incorrect s and t
        if (t.length() > s.length() || t.equals(""))
            return "";

        /*
         * we need two freq arr to track all required chars in t and all current chars
         * in window, since ww only have english lettere a 97, z 122, A 65, Z 90 ww can
         * use arr maps not needed
         */
        int[] req = new int[128];
        int[] winChars = new int[128];

        // make freq arr for t
        for (int i = 0; i < t.length(); i++) {
            req[t.charAt(i)]++;
        }

        // sliding window
        int left = 0, right = 0;
        int remaining = t.length();
        String min = "";
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            // moving right to expand window in s
            char ch = s.charAt(right);
            winChars[ch]++;
            // cheching if ch is required in t
            if (winChars[ch] <= req[ch])
                remaining--;

            /*
             * shrinking logic : when remaining == 0 then we have found at least one
             * substring so now we need to shrink so that we can make it
             * smaller or find more
             */
            while (remaining == 0) {
                // drop count of char at ch2 in winchars arr and move left ptr
                char ch2 = s.charAt(left);

                /*
                 * before moving left we also need to check if dropping char at left
                 * will cause remaining to go up i.e. we lose any chars required
                 */
                // if(winChars[ch2] > req[ch2]) continue;
                if (winChars[ch2] <= req[ch2]) {
                    /*
                     * if winChars dont have enough chars (ie. <= req[ch2]) then we need
                     * to record this substring before making this substring invalid
                     * by removing req characters
                     */
                    String substr = s.substring(left, right + 1);
                    if (minLen > substr.length()) {
                        min = substr;
                        minLen = substr.length();
                    }
                    /* we check if ch2 */
                    remaining++;
                }
                winChars[ch2]--;
                left++;
            }
            right++;
        }
        return min;
    }
}
