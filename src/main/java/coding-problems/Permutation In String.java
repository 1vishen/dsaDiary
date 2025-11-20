class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /* 1st soln, my way: sort and then find substring in s2 will be easy */

        /* 2ns soln, my way: The Two-Array Method: Create s1Freq (the target profile
        from s1). Create windowFreq (the current profile of the s2 window). In your
        loop, we just check: Is s1Freq exactly equal to windowFreq? (we'll need an 
        efficient helper function to do this check). */

        /* We make a freq array from s1, then slide a window over s2. We keep a
        'matched' count that increases only when a char entering the window fills a 
        needed slot. When a char enters we -- freq[c], and when it leaves we ++ 
        freq[c], so  freq[] always reflects how many chars are still needed or extra. */

        /* we cant skip chars in s2 that are not in s1 cause it will think we have a
        substring in window but in actuality we have more chars that are in window and
        in s2 but not in s1 correct? */

        if(s2.length() < s1.length()) return false;

        int[] freq = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        int matched = 0;

        for(right = 0; right < s2.length(); right++) {
            int in = s2.charAt(right) - 'a';

            freq[in]--;
            /* if freq[in] >= 0 after freq[in]-- then that was a needed char */
            if(freq[in] >= 0) {
                matched++;
            }

            // + 1 cause both ptr are included in length
            if((right - left + 1) > s1.length()) {
                int out = s2.charAt(left) - 'a';
                freq[out]++;
                /* after freq[out]++, if freq[out] > 0, we removed a needed char
                (one that was contributing to matched) */
                if(freq[out] > 0) matched--;
                left++;
            }

            if(matched == s1.length()) return true;
        }
        return false;
    }
}