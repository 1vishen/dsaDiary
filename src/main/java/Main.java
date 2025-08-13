import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    System.out.println("---");
    System.out.println(Solution.kthCharacter(5));
    System.out.println("---*---");
  }
}

class Solution {
    public static char kthCharacter(int k) {
        StringBuilder strC = new StringBuilder("a");

        while(strC.length() <= k) {
            StringBuilder temp = new StringBuilder(strC);
            for(int i = 0; i < strC.length(); i++) {
                temp.append((char) (strC.charAt(i) + 1));                                System.out.println(temp);
            }
            strC = temp;
        }
        return strC.charAt(k);
    }
}
