class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++) {
            String element = tokens[i];
            if(element.equals("+")) {
                int n1 = stack1.pop();
                int n2 = stack1.pop();
                int res = n1 + n2;
                stack1.push(res);
            }
            else if(element.equals("-")) {
                int n1 = stack1.pop();
                int n2 = stack1.pop();
                /* For RPN, second popped number is the left operand, 
                    first popped is right */
                int res = n2 - n1;
                stack1.push(res);
            }
            else if(element.equals("*")) {
                int n1 = stack1.pop();
                int n2 = stack1.pop();
                int res = n1 * n2;
                stack1.push(res);
            }
            else if(element.equals("/")) {
                int n1 = stack1.pop();
                int n2 = stack1.pop();
                // Qs guarantees no / by 0
                /* For RPN, second popped number is the left operand, 
                    first popped is right */
                int res = n2 / n1;
                stack1.push(res);
            }
            else {
                stack1.push(Integer.parseInt(element));
            }
        }
        return stack1.pop();
    }
}