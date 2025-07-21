class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;

        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }

        for(; i >= 0; i--){
            if(s.charAt(i) == ' ') break;
            else count++;
        }
        return count;
    }
}