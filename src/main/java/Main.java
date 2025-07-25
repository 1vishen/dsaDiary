import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    System.out.println("---");
    // JavaPracQues.main(new String[0]);
    System.out.println("---");
    System.out.println(Solution.isIsomorphic("srsr", "baba"));
    System.out.println("---*---");
  }
}

class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(s2t.containsKey(sc) && s2t.get(sc) != tc) return false;
            if(t2s.containsKey(tc) && t2s.get(tc) != sc) return false;
            if(!s2t.containsKey(sc)) {
                s2t.put(sc, tc);
                t2s.put(tc, sc);
            }
        }
        return true;
    }
}