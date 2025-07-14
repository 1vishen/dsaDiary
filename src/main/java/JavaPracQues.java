import java.util.*;

// Java DSA Practice Questions
// solution below each question in this file

public class JavaPracQues {

    // ===========================
    // 1. Array-Based Questions
    // ===========================

    // 1. Write a Java program to find the largest and smallest element in an array.
    // largest: 10, smallest: 1
    public static class Class1 {
        static int[] arr = { 2, 4, 5, 7, 44, 5, 7 };
        static int max = arr[0], min = arr[0];

        public static int[] method1() {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i] < min)
                    min = arr[i];
            }
            int[] sol = { max, min };
            return sol;
        }
    }

    // 2. Write a Java program to find the average of all elements in an array.
    // Average: 5
    public static class Class2 {
        static int[] arr = { 1, 2, 3, 4, 5 };
        static int sum;

        public static int method2() {
            for (int num : arr) {
                sum += num;
            }
            sum = sum / arr.length;
            return sum;
        }
    }

    // 3. Write a Java program to remove duplicates from an array.
    // array without duplicates: 1 2 3 4 5 8 9 10
    public static class Class3 {
        static int[] arr = { 1, 2, 3, 4, 4, 5, 5, 6 };

        public static List<Integer> method3() {
            Arrays.sort(arr);
            List<Integer> sol = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (sol.isEmpty() || sol.get(sol.size() - 1) != arr[i]) {
                    sol.add(arr[i]);
                }
            }
            return sol;
        }
    }

    // 4. Write a Java program to reverse an array in place.
    // rev array: 10 10 9 8 5 5 5 5 4 4 3 2 1
    public static class Class4 {
        static int[] arr = { 1, 2, 3, 4, 5 };

        public static int[] method4() {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
            return arr;
        }
    }

    // 5. Write a Java program to sort an array in ascending order using bubble
    // sort.
    // not done
    public static class Class5 {
        static int[] arr = { 1, 6, 59, 6, 5, 4 };

        public static int[] method5() {
            for (int j = 0; j < arr.length; j++) {
                for (int i = 0; i < arr.length - 1 - j; i++) {
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }
            return arr;
        }
    }

    // ===========================
    // 2. Number-Based Questions
    // ===========================

    // 6. Write a Java program to print the Fibonacci series up to a given number.
    // 0 1 1 2 3 5 8 13 21 34
    public static class Class6 {
        static int n = 12;

        public static List<Integer> method6() {
            List<Integer> sol = new ArrayList<>(Arrays.asList(0, 1));
            for (int i = 2; i <= n; i++) {
                int nextNum = sol.get(i - 1) + sol.get(i - 2);
                sol.add(nextNum);
            }
            return sol;
        }
    }

    // 7. Write a Java program to find the factorial of a given number.
    // 120
    public static class Class7 {
        static int n = 5;
        static int fac;

        public static int method7() {
            for (int i = n; i > 0; i--) {
                fac *= i;
                i--;
            }
            return fac;
        }
    }

    // 8. Write a Java program to print the multiplication table of a given number.
    // multiplication table of 5..
    public static class Class8 {
        static int n = 5;

        public static void method8() {
            for (int i = 1; i < 10; i++) {
                System.out.println("Multi-Tab: " + n * i);
            }
        }
    }

    // 9. Write a Java program to check if a given number is prime or not.
    // true
    public static class Class9 {
        static int n = 11;

        public static boolean method9() {
            if (n == 0 || n == 1)
                return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }

    // 10. Write a Java program to find the sum of all even numbers between 1 and
    // 100.
    // 2550
    public static class Class10 {
        static int sum;

        public static int method10() {
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        }
    }

    // 11. Write a Java program to create a simple calculator using a switch case.
    // 5 + 3 = 8
    public static class Class11 {
        static int a = 10, b = 11;
        static char symbol = '+';

        public static void method11() {
            switch (symbol) {
                case '+':
                    System.out.println(a + b);
                    break;

                case '-':
                    System.out.println(a - b);
                    break;

                case '*':
                    System.out.println(a * b);
                    break;

                case '/':
                    System.out.println(a / b);
                    break;

                default:
                    System.out.println("Invalid Operation");

            }
        }
    }

    // 12. Write a Java program to find the day of the week based on the day number
    // (1-7) using a switch case.
    // Sunday
    public static class Class12 {
        static int n = 2;

        public static void method12() {
            switch (n) {
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thrusday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;
                case 7:
                    System.out.println("Sunday");
                    break;
            }
        }
    }

    // 13. Write a Java program to assign grades to students based on their marks
    // using a switch case.
    // Grade O
    public static class Class13 {
        static int marks = 92;

        public static void method13() {
            int finalMarks = (int) Math.floor(marks / 10);
            switch (finalMarks) {
                case 10:
                    System.out.println("Pass!");
                    break;
                case 9:
                    System.out.println("Pass!");
                    break;
                default:
                    System.out.println("Fail");
            }
        }
    }

    // ===========================
    // 3. Operators & Loops
    // ===========================

    // 14. Explain the difference between pre-increment (++) and post-increment
    // (++x) operators in Java with examples.
    // original num: 5 pre increment: 6 post increment, before: 6 post increment,
    // after: 7
    // 15. Write a Java program to demonstrate the behavior of pre-increment and
    // post-increment operators in a loop.
    // 0 1 2 and 1 2 3
    // 14 and 15 together
    public static class class1415 {
        public static void method1415() {
            int a = 5;
            System.out.println("num: " + a + "pre-inc: " + ++a + "post-inc: " + a++);
            System.out.println("post-inc again: " + a);
            for (int i = 1; i < 5; i++) {
                System.out.println(i);
            }
            for (int i = 1; i < 5; ++i) {
                System.out.println(i);
            }
        }
    }

    // ===========================
    // 4. String-Based Questions
    // ===========================

    // 16. Write a Java program to count the number of vowels in a given string.
    // num of vowels is: 21

    // 17. Write a Java program to check if a given string is a palindrome.
    // the given string is a palindrome

    // 18. Write a Java program to reverse a given string.
    // reversed string: dlroWolleH

    // 19. Write a Java program to find the length of a given string without using
    // the built-in length() method.
    // Length of the string: 10

    // 20. Write a Java program to compare two strings without using the built-in
    // equals() method.
    // comparison result: true

    // ===========================
    // 5. Searching, Sorting, Algorithms
    // ===========================

    // 21. Write a Java program to implement a binary search algorithm on a sorted
    // array.
    // Element found at index: 3

    // 22. Write a Java program to merge two sorted arrays into a single sorted
    // array.
    // not done

    // 23. Write a Java program to find the second largest element in an array.
    // Second largest element: 4

    // ===========================
    // 6. Nested Loops & Logic
    // ===========================

    // 24. Write a Java program to print the prime numbers within a given range
    // using nested loops.
    // Prime numbers: 2 3 5 7 11 13 17 19

    // 25. Write a Java program to calculate the power of a number using loops.
    // Result: 32

    // 26. Write a Java program to create a menu-driven program using a switch case
    // for various operations on a number.
    // Multiplication: 50

    // ===========================
    // 7. Operators & Expressions (Advanced)
    // ===========================

    // 27. Write a Java program to demonstrate the order of evaluation of
    // pre-increment and post-increment operators in expressions.
    // After pre-increment: 6, After post-increment: 6, Final value of num: 7

    // ===========================
    // 8. String Manipulation (Advanced)
    // ===========================

    // 28. Write a Java program to check if two strings are anagrams of each other.
    // Are 'listen' and 'silent' anagrams? true

    // 29. Write a Java program to remove all spaces from a given string.
    // String without spaces: HelloWorld!Howareyou?

    // 30. Write a Java program to find the longest common substring between two
    // strings.
    // not done
    // Longest common substring: substring11string22

    public static void main(String[] args) {
        // to test your solutions
    }
}
