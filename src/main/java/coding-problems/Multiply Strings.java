class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) return "0";
        if(num1.equals("0") || num2.equals("0")) return "0";
        int len = num1.length() + num2.length(); /* multiplication cant exceed no 
                                                of digits in individual nums */
        int[] resultArray = new int[len];

        for(int i = num1.length() - 1; i >= 0; i--) {
            int currDigit = num1.charAt(i) - '0';

            for(int j = num2.length() - 1; j >= 0; j--) {
                int currDigitIn2ndString = num2.charAt(j) - '0';
                int mul = currDigit * currDigitIn2ndString + resultArray[i + j + 1];
                /* we need to shift 1 place left as we do in written multiplication
                    thats why i+j+1 and i+j for carry cause carry is added to next mul */
                resultArray[i + j + 1] = mul % 10; // storing unit digit
                resultArray[i + j] += mul / 10; // propagating carry
            }
        }

        //convert int array to string for o/p
        int i = 0;
        while(i < resultArray.length && resultArray[i] == 0) {
            i++;
        }
        StringBuilder result = new StringBuilder();
        for(; i < resultArray.length; i++) {
            result.append(resultArray[i]);
        }
        return result.toString();
    }
}