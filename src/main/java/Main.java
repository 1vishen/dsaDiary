import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    System.out.println("---");
    // JavaPracQues.main(new String[0]);
    System.out.println("---");
    System.out.println(Solution.isAnagram("anagra", "nagara"));
    System.out.println("---*---");
  }
}

class Solution {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return  false;
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int indexS = 'z' - s.charAt(i);
            int indexT = 'z' - t.charAt(i);

            freqS[indexS] += 1;
            freqT[indexT] += 1;
        }

        for(int i = 0; i < 26; i++){
            if(freqS[i] != freqT[i]) return false;
        }
        return true;
    }
}