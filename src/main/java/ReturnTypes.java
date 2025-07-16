import java.util.*;

public class ReturnTypes {

    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
        method5();
    }

    // Example 1: List<Integer> sol with public List<Integer> method1()
    // This WORKS - declared type matches return type exactly
    public static List<Integer> method1() {
        List<Integer> sol = new ArrayList<>();
        sol.add(1);
        sol.add(2);
        sol.add(3);
        // ✓ WORKS: List<Integer> can be returned as List<Integer>
        return sol;
    }

    // Example 2: List<Integer> sol with public ArrayList<Integer> method2()
    // This FAILS - declared type is too broad for specific return type
    public static ArrayList<Integer> method2() {
        List<Integer> sol = new ArrayList<>();
        sol.add(4);
        sol.add(5);
        sol.add(6);
        // ✗ COMPILATION ERROR: Cannot return List<Integer> as ArrayList<Integer>
        // The compiler sees sol as List<Integer>, not ArrayList<Integer>
        // Uncomment the next line to see the error:
        // return sol;

        // WORKAROUND: Cast to ArrayList (risky) or declare as ArrayList
        return (ArrayList<Integer>) sol; // Risky cast - works here because we know it's ArrayList
    }

    // Example 3: ArrayList<Integer> sol with public List<Integer> method3()
    // This WORKS - specific type can be returned as broader type
    public static List<Integer> method3() {
        ArrayList<Integer> sol = new ArrayList<>();
        sol.add(7);
        sol.add(8);
        sol.add(9);
        // ✓ WORKS: ArrayList<Integer> can be returned as List<Integer>
        // This is polymorphism - subtype can substitute supertype
        return sol;
    }

    // Example 4: List<Integer> sol with public List<Object> method4()
    // This FAILS - generics are invariant, List<Integer> ≠ List<Object>
    public static List<Object> method4() {
        List<Integer> sol = new ArrayList<>();
        sol.add(10);
        sol.add(11);
        sol.add(12);
        // ✗ COMPILATION ERROR: List<Integer> cannot be returned as List<Object>
        // Even though Integer extends Object, List<Integer> does NOT extend
        // List<Object>
        // This is because generics are invariant in Java
        // Uncomment the next line to see the error:
        // return sol;

        // WORKAROUND: Create a new List<Object> and copy elements
        List<Object> result = new ArrayList<>(sol);
        return result;
    }

    // Example 5: List<Integer> sol with public List<T> method5()
    // This WORKS when T is Integer or supertype of Integer
    public static <T> List<T> method5() {
        // For this example, let's assume T is Integer
        @SuppressWarnings("unchecked")
        List<T> sol = (List<T>) new ArrayList<Integer>();
        // ✓ WORKS: When T is Integer, List<Integer> can be returned as List<T>
        return sol;
    }

}