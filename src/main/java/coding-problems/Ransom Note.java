class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int note = 0;
        StringBuilder sbr = new StringBuilder(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            for (int j = 0; j < sbr.length(); j++) {
                if (ransomNote.charAt(i) == sbr.charAt(j)) {
                    note++;
                    sbr.setCharAt(j, ' ');
                    break;
                }
            }
        }
        if (note == ransomNote.length())
            return true;
        else
            return false;
    }
}