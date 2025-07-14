import java.util.*;

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

    int[] nums = {0,1,0,3,12,3,0,0,0,6,7,0,8,0,7,5,0,8,0};
    int index = 0;
    for(int num : nums){
        if(num != 0) {
            nums[index++] = num;
        }

    }
    System.out.println(Arrays.toString(nums) + "\n");
    for(int i = index; i < nums.length; i++){
        nums[i] = 0;
    }
    System.out.println(Arrays.toString(nums));



    System.out.println("---*---");
  }
}
