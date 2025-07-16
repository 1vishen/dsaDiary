class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman2Int = new HashMap<>();

        roman2Int.put('I', 1);
        roman2Int.put('V', 5);
        roman2Int.put('X', 10);
        roman2Int.put('L', 50);
        roman2Int.put('C', 100);
        roman2Int.put('D', 500);
        roman2Int.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = roman2Int.get(s.charAt(i));
            if (i < s.length() - 1 && current < roman2Int.get(s.charAt(i + 1))) {
                result -= current; // subtractive case
            } else {
                result += current;
            }
        }
        return result;
    }
}