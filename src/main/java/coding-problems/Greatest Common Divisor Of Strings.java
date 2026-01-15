class Solution {
    public String gcdOfStrings(String str1, String str2) {
        /* using concept from Q "Repeated Substring Pattern" to check if a string has repeating pattern, we can use that twiceS = s + s and if we check in twiceS we will find full s somewhere in between */

        /* concept here is similar but we dont want smallest pattern but largest pattern, so we add both strings and reverse their positions and add them again, if both are equal that means a shared pattern exists at least */

        /* we can use gcd concept of getting gcd of their lengths and that will tell us length of largest shared pattern */

        if(! (str1 + str2).equals(str2 + str1)) return "";
        int i = gcd(str1.length(), str2.length());
        return str1.substring(0, i);
    }

    public int gcd(int a, int b) {
        /* People think lcm is like gcd but reverse (ie lcd) but no multiple is always equal or greater than numbers but gcd is smaller or equal to numbers so their naming is odd greatest used where we are taking about divisors and lowest used where we are talking about multiples that confused people
If we calculate the other two it will be useless, LCD is almost always 1
GCM is infinite
        */

        /* using euclid algo, if a num divides both a and b it also divides their difference */

        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}
