class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /* A **stack** is LIFO, so use `push/pop/peek` (head) or `addLast/pollLast/peekLast`
         consistently for top operations. A **queue** is FIFO, so enqueue with `addLast` and 
         dequeue with `pollFirst`. A **deque** supports both ends: head (`addFirst/pollFirst/
         peekFirst`) and tail (`addLast/pollLast/peekLast`), so pick one end and stick to it
        for clarity. */



        /* collisions only happen when a right moving asteroid is to the left of a left moving
        asteroid i.e. + appears earlier than - */

        Deque<Integer> stack1 = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            int currentAst = asteroids[i];
            boolean currentAstDestoryed = false;

            if (!stack1.isEmpty()) {
                if(currentAst < 0 && stack1.peekLast() > 0) {
                    // we need to do !stack1.isEmpty() first otherwise NullPointerException
                    while(!stack1.isEmpty() && stack1.peekLast() > 0) {
                        if(Math.abs(stack1.peekLast()) > Math.abs(currentAst)) {
                            // current ast will be destroyed
                            currentAstDestoryed = true;
                            break;
                        }
                        else if(Math.abs(stack1.peekLast()) == Math.abs(currentAst)) {
                            // both will be destroyed
                            stack1.pollLast();
                            currentAstDestoryed = true;
                            break;
                        }
                        else if(Math.abs(stack1.peekLast()) < Math.abs(currentAst)) {
                            /* ast in last place of stack will be destroyed and current ast
                            will keep moving */
                            stack1.pollLast();
                        }
                    }
                    if(!currentAstDestoryed) stack1.addLast(currentAst);
                }
                else stack1.addLast(currentAst);
            } 
            else stack1.addLast(currentAst);
        }
        return stack1.stream().mapToInt(x -> x.intValue()).toArray();
    }
}
