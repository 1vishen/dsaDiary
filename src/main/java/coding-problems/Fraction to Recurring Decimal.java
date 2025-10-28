class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> remMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        if (((numerator < 0) ^ (denominator < 0)) &&
                (numerator != 0 && denominator != 0))
            result.append("-");

        // converting to long to avoid overflow in * /
        long nu = Math.abs((long) numerator);
        long de = Math.abs((long) denominator);

        // adding whole num part
        result.append(nu / de);
        if (nu % de == 0)
            return result.toString();
        result.append(".");

        /* we ened to do long division to find repeating remainders, since its the 
         repeating remainders we want not repeating quotients, repeating quotients wont
         tell us what part is actually repeating */

        long rem = nu % de;
        while (rem != 0) {
            // 0. check if new remainder is in map (and before doing rem*10)
            if (remMap.containsKey(rem)) {
                result.append(")");
                // since append() doesnt have ability to add at specific index
                int bracketIndex = remMap.get(rem);
                result.insert(bracketIndex, "(");
                break;
            }

            /* 1. add rem (before rem*10) to map for tracking, in map we need to store
            position of quotients to know when remainders start repeating and for that
            we need to know the current length of result stringbuilder, .length()
            will auto-increase and will keep track of posn of the rem */
            remMap.put(rem, result.length());

            // 2.
            rem *= 10;
            // add zeros to the result until remainder >= denominator
            while (rem < de) {
                result.append("0");
                rem *= 10;
            }

            // 3.
            // append quotient to result
            result.append(rem / de);

            // calculate new remainder
            rem %= de;
        }
        return result.toString();
    }
}