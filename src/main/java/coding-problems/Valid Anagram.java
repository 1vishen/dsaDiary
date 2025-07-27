class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return  false;
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int indexS = s.charAt(i) - 'a';
            int indexT = t.charAt(i) - 'a';

            freqS[indexS] += 1;
            freqT[indexT] += 1;
        }

        for(int i = 0; i < 26; i++){
            if(freqS[i] != freqT[i]) return false;
        }
        return true;
    }
}