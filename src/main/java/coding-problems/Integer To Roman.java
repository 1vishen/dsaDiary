class Solution {
    public String intToRoman(int num) {
        String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] thousands = { "", "M", "MM", "MMM" };

        StringBuilder result = new StringBuilder();

        int digit = num % 10; // 3749 9
        result.insert(0, ones[digit]);
        num /= 10; // 374

        digit = num % 10; // 374 4
        result.insert(0, tens[digit]);
        num /= 10; // 37

        digit = num % 10; // 37 7
        result.insert(0, hundreds[digit]);
        num /= 10; // 3

        digit = num;
        result.insert(0, thousands[digit]);

        return result.toString();

    }
}