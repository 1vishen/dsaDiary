import java.util.*;

// Java DSA Practice Questions
// solution below each question in this file

public class JavaPracQues {

    // ===========================
    // 1. Array-Based Questions
    // ===========================

    // 1. Write a Java program to find the largest and smallest element in an array.
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
    public static class Class4 {
        static int[] arr = { 1, 2, 3, 4, 5 };

        public static int[] method4() {
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
            return arr;
        }
    }

    // 5. Write a Java program to sort an array in ascending order using bubble
    // sort.
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
    public static class Class7 {
        static int n = 5;
        static int fac = 1;

        public static int method7() {
            for (int i = n; i > 0; i--) {
                fac *= i;
                i--;
            }
            return fac;
        }
    }

    // 8. Write a Java program to print the multiplication table of a given number.
    public static class Class8 {
        static int n = 5;

        public static void method8() {
            for (int i = 1; i < 10; i++) {
                System.out.println("Multi-Tab: " + n * i);
            }
        }
    }

    // 9. Write a Java program to check if a given number is prime or not.
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
    public static class Class10 {
        static int sum;

        public static int method10() {
            for (int i = 2; i <= 100; i += 2) {
                sum += i;
            }
            return sum;
        }
    }

    // 11. Write a Java program to create a simple calculator using a switch case.
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
    // 15. Write a Java program to demonstrate the behavior of pre-increment and
    // post-increment operators in a loop.
    public static class Class1415 {
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
    public static class Class16 {
        static String str = "Hello";
        static int count = 0;

        public static int method16() {
            for (int i = 0; i < str.length(); i++) {
                str.toLowerCase();
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
                        str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                    count++;
                }
            }
            return count;
        }
    }

    // 17. Write a Java program to check if a given string is a palindrome.
    public static class Class17 {
        static String str = "Allo";

        public static boolean method17() {
            str.toLowerCase();
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - i - 1))
                    return false;
            }
            return true;
        }
    }

    // 18. Write a Java program to reverse a given string.
    public static class Class18 {
        static String str = "Hello";

        public static String method18() {
            StringBuilder sbr = new StringBuilder(str);
            for (int i = 0; i < sbr.length() / 2; i++) {
                char temp = sbr.charAt(i);
                sbr.setCharAt(i, sbr.charAt(sbr.length() - i - 1));
                sbr.setCharAt((sbr.length() - i - 1), temp);
            }
            str = sbr.toString();
            return str;
        }
    }

    // 19. Write a Java program to find the length of a given string without using
    // the built-in length() method.
    public static class Class19 {
        static String str = "Hello";
        static int count = 0;

        public static int method19() {
            for (char s : str.toCharArray()) {
                System.out.print(s + " ");
                count++;
            }
            return count;
        }
    }

    // 20. Write a Java program to compare two strings without using the built-in
    // equals() method.
    public static class Class20 {
        static String str1 = "Hello";
        static String str2 = "Hello2";

        public static boolean method20() {
            if (str1.length() != str2.length())
                return false;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i))
                    return false;
            }
            return true;
        }
    }

    // ===========================
    // 5. Searching, Sorting, Algorithms
    // ===========================

    // 21. Write a Java program to implement a binary search algorithm on a sorted
    // array.
    public static class Class21 {
        static int[] arr = { 1, 3, 4, 5, 7, 8, 9 };
        static int target = 8;
        static int left = 0, right = arr.length - 1;
        static int mid;

        public static int method21() {
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (arr[mid] == target)
                    return mid;
                if (target > arr[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return -1;
        }
    }

    // 22. Write a Java program to merge two sorted arrays into a single sorted
    // array.
    public static class Class22 {
        static int[] arr1 = { 1, 2, 4, 33, 66, 77, 101 };
        static int[] arr2 = { 2, 6, 7, 9, 22, 55, 99 };

        public static List<Integer> method22() {
            List<Integer> sol = new ArrayList<>();
            int i = 0, j = 0;
            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] <= arr2[j]) {
                    sol.add(arr1[i]);
                    i++;
                } else {
                    sol.add(arr2[j]);
                    j++;
                }
            }
            while (i < arr1.length) {
                sol.add(arr1[i]);
                i++;
            }
            while (j < arr2.length) {
                sol.add(arr2[j]);
                j++;
            }
            return sol;
        }
    }

    // 23. Write a Java program to find the second largest element in an array.
    public static class Class23 {
        static int[] arr = { 1, 2, 3, 4, 5 };
        static int secMax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;

        public static int method23() {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    secMax = max;
                    max = arr[i];
                } else if (arr[i] > secMax && arr[i] != max)
                    secMax = arr[i];
            }
            return secMax;
        }
    }

    // ===========================
    // 6. Nested Loops & Logic
    // ===========================

    // 24. Write a Java program to print the prime numbers within a given range
    // using nested loops.
    public static class Class24 {
        static int n = 20;

        public static void method24() {
            for (int i = 2; i < n; i++) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }

                }
                if (isPrime) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    // 25. Write a Java program to calculate the power of a number using loops.
    public static class Class25 {
        static int n = 5;
        static int power = 3;

        public static int method25() {
            int result = 1;
            if (power == 0)
                return 1;
            if (power == 1)
                return n;

            for (int i = 1; i <= power; i++) {
                result *= n;
            }
            return result;
        }
    }

    // 26. Write a Java program to create a menu-driven program using a switch case
    // for various operations on a number.
    public static class Class26 {
        static int a = 5, b = 6;
        static int option = 1;
        // static Scanner sc = new Scanner(System.in);

        public static void method26() {
            // int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Add: " + (a + b));
                    break;
                case 2:
                    System.out.println("Sub: " + (a - b));
                    break;
                case 3:
                    System.out.println("Mul: " + (a * b));
                    break;
                case 4:
                    System.out.println("Div: " + (a / b));
                    break;
                default:
                    System.out.println("Invalid Input");
            }

        }
    }

    // ===========================
    // 7. Operators & Expressions (Advanced)
    // ===========================

    // 27. Write a Java program to demonstrate the order of evaluation of
    // pre-increment and post-increment operators in expressions.
    public static class Class27 {
        static int a = 1, b = 1;

        public static void method27() {
            System.out.println(
                    "original: " + a + b + " ++a + b: " + (++a + b) + " a++ + b: " + (a++ + b) + "new: " + a + b);
        }
    }

    // ===========================
    // 8. String Manipulation (Advanced)
    // ===========================

    // 28. Write a Java program to check if two strings are anagrams of each other.
    public static class Class28 {
        static String str1 = "Listen";
        static String str2 = "Silent";

        public static boolean method28() {
            if (str1.length() != str2.length())
                return false;

            char[] char1 = str1.toLowerCase().toCharArray();
            char[] char2 = str2.toLowerCase().toCharArray();
            Arrays.sort(char1);
            Arrays.sort(char2);

            for (int i = 0; i < char1.length; i++) {
                if (char1[i] != char2[i])
                    return false;
            }
            return true;
        }
    }

    // 29. Write a Java program to remove all spaces from a given string.
    public static class Class29 {
        static String str = "Hello Everyone This is a String";

        public static String method29() {
            String[] strArray = str.split(" ");
            str = String.join("", strArray);
            return str;
        }
    }

    // 30. Write a Java program to find the longest common substring between two
    // strings.
    public static class Class30 {
        static String str1 = "HelloThisisaString";
        static String str2 = "Thisis";

        public static String method30() {
            String longer = str1.length() >= str2.length() ? str1 : str2;
            String shorter = str1.length() < str2.length() ? str1 : str2;
            String longestSubStr = "";

            for (int i = 0; i < shorter.length(); i++) {
                for (int j = i + 1; j <= shorter.length(); j++) {
                    String tempSubStr = shorter.substring(i, j);
                    if (longer.contains(tempSubStr) && tempSubStr.length() > longestSubStr.length()) {
                        longestSubStr = tempSubStr;
                    }
                }
            }
            return longestSubStr;
        }
    }

    public static void main(String[] args) {
        // to check solutions
        System.out.println("---START---");
        System.out.println("Class1: " + Arrays.toString(Class1.method1()));
        System.out.println("Class2: " + Class2.method2());
        System.out.println("Class3: " + Class3.method3());
        System.out.println("Class4: " + Arrays.toString(Class4.method4()));
        System.out.println("Class5: " + Arrays.toString(Class5.method5()));
        System.out.println("Class6: " + Class6.method6());
        System.out.println("Class7: " + Class7.method7());
        System.out.println("Class8:");
        Class8.method8();
        System.out.println("Class9: " + Class9.method9());
        System.out.println("Class10: " + Class10.method10());
        System.out.println("Class11:");
        Class11.method11();
        System.out.println("Class12:");
        Class12.method12();
        System.out.println("Class13:");
        Class13.method13();
        System.out.println("Class1415:");
        Class1415.method1415();
        System.out.println("Class16: " + Class16.method16());
        System.out.println("Class17: " + Class17.method17());
        System.out.println("Class18: " + Class18.method18());
        System.out.println("Class19: " + Class19.method19());
        System.out.println("Class20: " + Class20.method20());
        System.out.println("Class21: " + Class21.method21());
        System.out.println("Class22: " + Class22.method22());
        System.out.println("Class23: " + Class23.method23());
        System.out.println("Class24:");
        Class24.method24();
        System.out.println();
        System.out.println("Class25: " + Class25.method25());
        System.out.println("Class26:");
        Class26.method26();
        System.out.println("Class27:");
        Class27.method27();
        System.out.println("Class28: " + Class28.method28());
        System.out.println("Class29: " + Class29.method29());
        System.out.println("Class30: " + Class30.method30());
        System.out.println("---END---");
    }

}

/*
 * OUTPUTS:
 * ---START---
 * Class1: [44, 2]
 * Class2: 3
 * Class3: [1, 2, 3, 4, 5, 6]
 * Class4: [5, 4, 3, 2, 1]
 * Class5: [1, 4, 5, 6, 6, 59]
 * Class6: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144]
 * Class7: 15
 * Class8:
 * Multi-Tab: 5
 * Multi-Tab: 10
 * Multi-Tab: 15
 * Multi-Tab: 20
 * Multi-Tab: 25
 * Multi-Tab: 30
 * Multi-Tab: 35
 * Multi-Tab: 40
 * Multi-Tab: 45
 * Class9: true
 * Class10: 2550
 * Class11:
 * 21
 * Class12:
 * Tuesday
 * Class13:
 * Pass!
 * Class1415:
 * num: 5pre-inc: 6post-inc: 6
 * post-inc again: 7
 * 1
 * 2
 * 3
 * 4
 * 1
 * 2
 * 3
 * 4
 * Class16: 2
 * Class17: false
 * Class18: olleH
 * H e l l o Class19: 5
 * Class20: false
 * Class21: 5
 * Class22: [1, 2, 2, 4, 6, 7, 9, 22, 33, 55, 66, 77, 99, 101]
 * Class23: 4
 * Class24:
 * 2 3 5 7 11 13 17 19
 * Class25: 125
 * Class26:
 * Add: 11
 * Class27:
 * original: 11 ++a + b: 3 a++ + b: 3new: 31
 * Class28: true
 * Class29: HelloEveryoneThisisaString
 * Class30: Thisis
 * ---END---
 */