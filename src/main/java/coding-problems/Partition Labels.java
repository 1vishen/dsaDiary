class Solution {
    public List<Integer> partitionLabels(String s) {
        /*
         * We track the total frequency of each character. As we walk the
         * string, we increment a counter for every "new" letter we meet and
         * decrement its frequency. when a letter's frequency hits 0, we decrement
         * our counter. Once that counter reaches 0, all letters in our current
         * window are self-contained, so we cut the partition and reset.
         */

        int[] freq = new int[26];
        int lettersToComplete = 0;
        Set<Character> different = new HashSet<>();
        int lenSubStr = 0;
        List<Integer> ans = new ArrayList<>();

        // make freq arr
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // main logic
        for (int i = 0; i < s.length(); i++) {
            // count length of current substr at start
            lenSubStr++;

            char c = s.charAt(i);

            // if we see a new char, increase lettersToComplete
            if (different.contains(c) == false) {
                different.add(c);
                lettersToComplete++;
            }

            // decrease freq of current char
            freq[c - 'a']--;

            // check if freq of any char became 0
            if (freq[c - 'a'] == 0)
                lettersToComplete--;

            // when lettersToComplete = 0, we have found a ans substr
            if (lettersToComplete == 0) {
                ans.add(lenSubStr);
                lenSubStr = 0;
                // reset the set
                different.clear();
            }
        }
        return ans;
    }
}
