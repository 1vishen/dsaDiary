
class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false;

                char p = stack.pop();
                if (c == ')' && p != '(' ||
                        c == '}' && p != '{' ||
                        c == ']' && p != '[')
                    return false;
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;

    }
}