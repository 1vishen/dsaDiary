class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /* Stack stores indices of days that are still waiting for a warmer temperature,
        if we find warmer day we get answers for ech index waiting in stack */

        Deque<Integer> stack1 = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        Arrays.fill(result, 0);

        for(int i = 0; i < temperatures.length; i++) {
            while(stack1.isEmpty() == false && 
                temperatures[i] > temperatures[stack1.peekLast()]) {
                // no of days wait = current index - stored index
                int topIndex = stack1.pollLast();
                result[topIndex] = i - topIndex;
            }
            /* if, stack1.isEmpty() == true OR
                temperatures[i] <= temperatures[stack1.peekLast()]  */
                stack1.addLast(i);
        }
        return result;
    }
}