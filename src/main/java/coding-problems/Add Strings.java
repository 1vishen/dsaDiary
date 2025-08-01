class Solution {
    public String addStrings(String num1, String num2) {
        int pointer1 = num1.length() != 0 ? num1.length() - 1 : 0;
        int pointer2 = num2.length() != 0 ? num2.length() - 1 : 0;
        StringBuilder result = new StringBuilder();
        int sum = 0, carry = 0;

        while(pointer1 >= 0 || pointer2 >= 0 || carry > 0) {
            int digit1 = pointer1 >= 0 ? num1.charAt(pointer1--) - '0' : 0;
            int digit2 = pointer2 >= 0 ? num2.charAt(pointer2--) - '0' : 0;
            sum = digit1 + digit2 + carry;
            /* quotient is carry, remainder is actual sum digit 
            e.g. 9 + 9 = 18 → carry = 1 (18 / 10), actual sum digit = 8 (18 % 10)
            */
            result.append(sum % 10);
            carry = sum / 10;
        }
        return result.reverse().toString();
    }
}