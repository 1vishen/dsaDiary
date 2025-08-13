class Solution {
    public char kthCharacter(int k) {
        StringBuilder strC = new StringBuilder("a");

        while(strC.length() <= k) {
            StringBuilder temp = new StringBuilder(strC);
            for(int i = 0; i < strC.length(); i++) {
                temp.append((char) (strC.charAt(i) + 1));                
            }
            strC = temp;
        }
        return strC.charAt(k - 1); //strings are 0-indexed whereas k need 1-indexed
    }
}