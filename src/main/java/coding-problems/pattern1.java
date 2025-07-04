package coding;

public class pattern1 {
  public static void main(String[] args) {

    System.out.println("\npattern1.main called");
    int n = 5;
    char ch = '*';
    for (int i = 1; i <= n; i++) {
      System.out.println(ch);
    }

    System.out.println("\nPattern 2 printed");
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(ch);
      }
      System.out.println();
    }

    System.out.println("\nPattern 3 printed");
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i + 1; j++) {
        System.out.print(ch);
      }
      System.out.println();
    }

    System.out.println("\nPattern 4 printed");
    char ch2 = 'A';
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i + 1; j++) {
        System.out.print(ch2);
      }
      System.out.println();
    }

    System.out.println("\nPattern 5 printed");
    char ch3 = 'A';
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(ch3++);
      }
      System.out.println();
    }

    System.out.println("\nPattern 6 printed");
    char ch4 = 'A';
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(ch4++);
      }
      ch4 = 'A';
      System.out.println();
    }

    System.out.println("\nPattern 7 printed");
    // Top half of the pattern
    for (int i = 0; i < n; i++) {
      // Left stars
      for (int j = 0; j < n - i; j++) {
        System.out.print("*");
      }
      // Middle spaces
      for (int j = 0; j < 2 * i; j++) {
        System.out.print(" ");
      }
      // Right stars
      for (int j = 0; j < n - i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    // Bottom half of the pattern
    for (int i = n - 1; i >= 0; i--) {
      // Left stars
      for (int j = 0; j < n - i; j++) {
        System.out.print("*");
      }
      // Middle spaces
      for (int j = 0; j < 2 * i; j++) {
        System.out.print(" ");
      }
      // Right stars
      for (int j = 0; j < n - i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    System.out.println("\nend");

  }
}