import java.util.*;

public class FebPrac {
    public static void main(String[] args) {
        int[] array = { 5, 8, 2, 1, 9, 3, 4, 4, 5, 5, 5, 10, 10 };
        System.out.println("\n* Write a Java program to find the largest a smallest element in an array.");
        ArrayQs.larSmall(array);

        System.out.println("\n* Write a Java program to find the average of all elements in an array.");
        ArrayQs.avg(array);

        System.out.println("\n* Write a Java program to remove duplicates from an array.");
        ArrayQs.remDup(array);

        System.out.println("\n* Write a Java program to reverse an array in place.");
        ArrayQs.rev(array);

        System.out.println("\n* Write a Java program to sort an array in ascending order using bubble sort.");
        ArrayQs.bubbleSort(array);

        System.out.println("\n* Write a Java program to print the Fibonacci series up to a given number.");
        NumberQs.fibo(10);

        System.out.println("\n* Write a Java program to find the factorial of a given number using a");
        System.out.println(NumberQs.factorial(5));

        System.out.println("\n* Write a Java program to print the multiplication table of a given number.");
        NumberQs.multiptable(5);

        System.out.println("\n* Write a Java program to check if a given number is prime or not.");
        System.out.println(NumberQs.primeNum(17));

        System.out.println("\n* Write a Java program to find the sum of all even numbers between 1 and 100.");
        System.out.println(NumberQs.sumEven());

        System.out.println("\n* Write a Java program to create a simple calculator using a switch case.");
        Calculator.cal(5, 3, '+');

        System.out.println(
                "\n* Write a Java program to find the day of the week based on the day number (1-7) using a switch case.");
        WeekDay.whichDay(7);

        System.out.println(
                "\n* Write a Java program to assign grades to students based on their marks using a switch case.");
        GradingStu.giveGrade(100);

        System.out.println(
                "\nPre-increment and Post-increment \n* Explain the difference between pre-increment (++) and post-increment (++x) operators in Java with examples.");
        PrePostNdString.prePostEg(5);

        System.out.println(
                "\n* Write a Java program to demonstrate the behavior of pre-increment and post-increment operators in a loop.");
        PrePostNdString.prePostLoop(5);

        System.out.println("\n* Write a Java program to count the number of vowels in a given string.");
        PrePostNdString.countVowels("Write a Java program to count the number of vowels in a given string");

        System.out.println("\n* Write a Java program to check if a given string is a palindrome.");
        PrePostNdString.palindrome("Palinilap");

        System.out.println("\n* Write a Java program to reverse a given string.");
        PrePostNdString.revstr("HelloWorld");

        System.out.println(
                "\n* Write a Java program to find the length of a given string without using the built-in length() method.");
        int length = PrePostNdString.findLength("HelloWorld");
        System.out.println("Length of the string: " + length);

        System.out
                .println("\n* Write a Java program to compare two strings without using the built-in equals() method.");
        System.out.println("comparison result: " + PrePostNdString.compStr("Hello", "Hello"));

        System.out.println("\n* Write a Java program to implement a binary search algorithm on a sorted array.");
        int[] sortedArray = { 1, 3, 5, 7, 9, 11, 13 };
        System.out.println("Element found at index: " + PrePostNdString.binarySearch(sortedArray, 7));

        System.out.println("\n* Write a Java program to merge two sorted arrays into a single sorted array.");
        int[] array1 = { 1, 3, 5 };
        int[] array2 = { 2, 4, 6 };
        PrePostNdString.mergeSortedArrays(array1, array2);

        System.out.println("\n* Write a Java program to find the second largest element in an array.");
        int[] array3 = { 5, 3, 9, 1, 8, 12 };
        System.out.println("Second largest element: " + PrePostNdString.findSecondLargest(array2));

        System.out.println(
                "\n* Write a Java program to print the prime numbers within a given range using nested loops.");
        PrePostNdString.printPrimesInRange(1, 20);

        System.out.println("\n* Write a Java program to calculate the power of a number using loops.");
        System.out.println("Result: " + PrePostNdString.calculatePower(2, 5));

        System.out.println(
                "\n* Write a Java program to create a menu-driven program using a switch case for various operations on a number.");
        PrePostNdString.menuDrivenCalculator(10, 5, '*');

        System.out.println(
                "\n* Write a Java program to demonstrate the order of evaluation of pre-increment and post-increment operators in expressions.");
        PrePostNdString.prePostEg2(5);

        System.out.println("\n* Write a Java program to check if two strings are anagrams of each other.");
        System.out.println("Are 'listen' and 'silent' anagrams? " + PrePostNdString.checkAnagrams("listen", "silent"));

        System.out.println("\n* Write a Java program to remove all spaces from a given string.");
        System.out.println("String without spaces: " + PrePostNdString.removeSpaces("Hello World! How are you?"));

        System.out.println("\n* Write a Java program to find the longest common substring between two strings.");
        System.out.println(
                "Longest common substring: " + PrePostNdString.findLongestCommonSubstring("substring11", "string22"));
    }
}

class ArrayQs {
    public static void larSmall(int[] array) {
        int l = array[0];
        int s = array[0];
        for (int i : array) {
            if (i > l) {
                l = i;
            }
            if (i < s) {
                s = i;
            }
        }
        System.out.println("largest: " + l + ", smallest: " + s);
    }

    public static void avg(int[] array) {
        int size = array.length;
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println("Average: " + (sum / size));
    }

    public static void remDup(int[] array) {
        int size = array.length;
        int[] newArr = new int[size];
        int index = 0;
        Arrays.sort(array);
        for (int i = 0; i < size; i++) {
            if (i == 0 || (array[i] != array[i - 1])) {
                newArr[index++] = array[i];
            }
        }

        System.out.println("array without duplicates: ");
        for (int i = 0; i < index; i++) {
            System.out.print(newArr[i] + " ");
        }
        System.out.println();
    }

    public static void rev(int[] array) {
        System.out.print("rev array: ");
        for (int i = (array.length - 1); i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {

        System.out.println("not done");
    }
}

class NumberQs {
    public static void fibo(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void multiptable(int n) {
        System.out.println("multiplication table of " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    public static boolean primeNum(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int sumEven() {
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        return sum;
    }
}

class Calculator {
    public static void cal(int a, int b, char sym) {
        switch (sym) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '/':
                if (b != 0) {
                    System.out.println(a + " / " + b + " = " + (a / (double) b));
                } else {
                    System.out.println("can;t divide by zero");
                }
                break;
            default:
                System.out.println("invalid symbol");
        }
    }
}

class WeekDay {
    public static void whichDay(int day) {
        switch (day) {
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
                System.out.println("Thursday");
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
            default:
                System.out.println("invalid day number");
        }
    }
}

class GradingStu {
    public static void giveGrade(int marks) {
        switch (marks / 10) {
            case 10:
                System.out.println("Grade O");
                break;
            case 9:
                System.out.println("Grade A");
                break;
            case 8:
                System.out.println("Grade B");
                break;
            case 7:
                System.out.println("Grade C");
                break;
            case 6:
                System.out.println("Grade D");
                break;
            default:
                System.out.println("Grade F");
        }
    }
}

class PrePostNdString {
    public static void prePostEg(int num) {
        System.out.print("original num: " + num + " pre increment: " + ++num + " post increment, before: " + num++);
        System.out.println(" post increment, after: " + num);
    }

    public static void prePostLoop(int num) {
        for (int i = 0; i < 3;) {
            System.out.println(i++);
        }
        System.out.println();
        for (int i = 0; i < 3;) {
            System.out.println(++i);
        }
    }

    public static void countVowels(String str) {
        int size = str.length();
        int[] vowelStr = new int[10];
        int count = 0;

        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {

                count++;

            }
        }

        System.out.println("num of vowels is: " + count);

    }

    public static void palindrome(String str) {
        int size = str.length();
        str = str.toLowerCase();
        boolean isP = true;
        for (int i = 0; i < size / 2; i++) {
            if (str.charAt(i) != str.charAt(size - i - 1)) {
                System.out.println("the given string is not a palindrome");
                isP = false;
                break;
            }
        }
        if (isP) {
            System.out.println("the given string is a palindrome");
        }
    }

    public static void revstr(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("reversed string: " + reversed);
    }

    public static int findLength(String str) {
        int length = 0;
        for (char c : str.toCharArray()) {
            length++;
        }
        return length;
    }

    public static boolean compStr(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }

    public static void mergeSortedArrays(int[] arr1, int[] arr2) {
        System.out.println("not done");
    }

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    public static void printPrimesInRange(int start, int end) {
        System.out.print("Prime numbers: ");
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int calculatePower(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void menuDrivenCalculator(int num1, int num2, char operation) {
        switch (operation) {
            case '+':
                System.out.println("Addition: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Subtraction: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Multiplication: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Division: " + (num1 / (double) num2));
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    public static void prePostEg2(int num) {
        int preIncrement = ++num;
        System.out.println("After pre-increment: " + preIncrement);
        int postIncrement = num++;
        System.out.println("After post-increment: " + postIncrement);
        System.out.println("Final value of num: " + num);
    }

    public static boolean checkAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        return java.util.Arrays.equals(arr1, arr2);
    }

    public static String removeSpaces(String str) {
        return str.replaceAll("\\s", "");
    }

    public static String findLongestCommonSubstring(String str1, String str2) {
        System.out.println("not done");
        return str1 + str2;
    }

}
