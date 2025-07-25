import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    System.out.println("---");
    // JavaPracQues.main(new String[0]);
    System.out.println("---");
    boolean bool1 = Solution.isIsomorphic("badc", "baba");
    System.out.println(bool1);
    System.out.println("---*---");
  }
}

class Solution {
  public static boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length())
      return false;
    
    Map<Character, Character> sToT = new HashMap<>();
    Map<Character, Character> tToS = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      
      // Check if sChar is already mapped
      if (sToT.containsKey(sChar)) {
        if (sToT.get(sChar) != tChar) {
          return false;
        }
      } else {
        sToT.put(sChar, tChar);
      }
      
      // Check if tChar is already mapped
      if (tToS.containsKey(tChar)) {
        if (tToS.get(tChar) != sChar) {
          return false;
        }
      } else {
        tToS.put(tChar, sChar);
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
