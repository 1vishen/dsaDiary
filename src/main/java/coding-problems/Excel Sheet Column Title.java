class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        while(columnNumber > 0){
            columnNumber--; //because excel is 1 - indexed not 0 indexed
            rem = columnNumber % 26;
            sb.append((char)('A' + rem));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}