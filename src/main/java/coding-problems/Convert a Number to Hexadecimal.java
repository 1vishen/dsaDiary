class Solution {
    public String toHex(int num) {
        // Masking with 0xF (binary 00001111) isolates the last 4 bits—1 hex digit—since hex is base-16.
        if(num == 0) return new String("0");
        StringBuilder result = new StringBuilder();
        while(num != 0) {
            int digit = num & 0xF;
            num = num >>> 4;
            if(digit <= 9) result.append(digit);
            else result.append((char)('a' + digit - 10));
        }
        return result.reverse().toString();
    }
}