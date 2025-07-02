package coding;

public class pattern1 {
  public static void main(String[] args) {
    System.out.println("pattern1.main called");
    int n = 5;
    char ch = '*';
    for (int i = 1; i <= n; i++) {
      System.out.println(ch);
    }
    System.out.println("Pattern 1 printed");
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(ch);
      }
      System.out.println(); // Add newline after each row
    }
  }
}