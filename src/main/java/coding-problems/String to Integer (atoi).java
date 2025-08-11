class Solution {
    public int myAtoi(String s) {
        int result = 0;
        int correctSign = 1;
        int i = 0;

        String newS = s.trim();
        if(newS.isEmpty()) return 0;

        if(newS.charAt(0) == '-') {
            correctSign = -1;
            i = 1;
        }
        else if(newS.charAt(0) == '+') {
            i = 1;
        }

        while(i < newS.length()) {
            char ch = newS.charAt(i);
            if(!Character.isDigit(ch)) break;
            else {
                int nextDigit = ch - '0';
                if(result <= (Integer.MAX_VALUE - nextDigit) / 10)
                    result = result * 10 + nextDigit;
                else {
                    return correctSign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
            i++;
        }

        return result * correctSign;

    }
}