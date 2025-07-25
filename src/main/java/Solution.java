import java.util.*;

public class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> mapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mapping.containsKey(s.charAt(i)) == false) {
                mapping.put(s.charAt(i), t.charAt(i));
            } else if (mapping.containsKey(s.charAt(i)) && (mapping.get(s.charAt(i)) == t.charAt(i))) {
                continue;
            } else if (mapping.containsValue(t.charAt(i)) && getKeyByValue(mapping, t.charAt(i)) == s.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static Character getKeyByValue(Map<Character, Character> map, char value) {
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }
}