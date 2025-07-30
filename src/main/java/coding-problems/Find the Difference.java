class Solution {
    public char findTheDifference(String s, String t) {
        int[] strMap = new int[26];
        char chS = ' ';

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(i < t.length() - 1) {
                chS = s.charAt(i);
                strMap[chS - 'a']--;
            }
            strMap[ch - 'a']++;
        }
        for(int i = 0; i < strMap.length; i++) {
            if(strMap[i] > 0) return (char) ('a' + i);
        }
        return ' ';
    }
}