import java.util.Arrays;

public class PerformanceTesting {
  public static void main(String[] args) {
    System.out.println("\nPerformance Testing...Started!");
    int[] arr = { 7, 5, 9, 2, 1 };
    for (int i = 0; i < 50000; i++) {
      Arrays.sort(arr);
      // System.out.println(Arrays.toString(arr));
    }
    System.out.println("Performance Testing...Ended!");
  }
}