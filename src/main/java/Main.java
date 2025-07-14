import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    System.out.println("---");
    AnonymousClass.main(new String[0]);
    System.out.println("---");
    RuntimePoly.main(new String[0]);
    System.out.println("---");
    PerformanceTesting.main(new String[0]);
    System.out.println("---");


    int num = 121;
    int y = num;
    List<Integer> digitList = new ArrayList<>();
    while(y != 0){
        int digit = y % 10;
        if(num % digit == 0 && !digitList.contains(digit) && digit != 0) 
        digitList.add(digit);
        y = y / 10;
    }
    System.out.println(digitList.size() + " " + digitList);

  }
}
