class Solution {
    public int[] getOrder(int[][] tasks) {
        /*
         * okay so enque time only decides when task enters cpu after it enter then
         * processing flow is decided by processing time (and index as tie breaker)
         * so if 2 task have same enque I should send them both and then inside cpu
         * I decide which to run 1st
         */

        // first store index values in new tasks arr
        int[][] newTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }

        // now sort new arr by enqueue time asc
        Arrays.sort(newTasks, (a, b) -> Integer.compare(a[0], b[0]));

        // make min heap, sort it by processing time asc
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap1 = new PriorityQueue<>(
                (a, b) -> {
                    /*
                     * since wrapped classes like Integer as objects == wont work cause it
                     * will give reference comparison not content comparison
                     */
                    if (a.getKey().equals(b.getKey()))
                        return Integer.compare(a.getValue(), b.getValue());
                    else
                        return Integer.compare(a.getKey(), b.getKey());
                });
        // storing result
        int[] result1 = new int[tasks.length];

        /*
         * CPU scheduling problem requires simulating time: need a variable time that
         * represents the CPU’s current time, tasks should be added to the heap when
         * their
         * enqueue time ≤ time.
         */
        long time = 0;
        // i for traversing newTasks arr, j for traversing result1 arr
        int i = 0, j = 0;
        // we stop when we ahve traversed all tasks in newTasks arr or our heap is empty
        while (i < newTasks.length || minHeap1.isEmpty() == false) {
            // add all tasks with enqueue time <= cpu time
            while (i < newTasks.length && newTasks[i][0] <= time) {
                minHeap1.offer(
                        new java.util.AbstractMap.SimpleEntry<>(newTasks[i][1], newTasks[i][2]));
                i++;
            }

            /*
             * now we simulate cpu by poll 1 task as its porcessing time to our cpu
             * time and add its index to our result
             */
            if (minHeap1.isEmpty() == false) {
                Map.Entry<Integer, Integer> task = minHeap1.poll();
                time += task.getKey();
                result1[j] = task.getValue();
                j++;
            } else {
                /*
                 * this else means that our cpu is idle so we need to skip idle time
                 * and move it to enqueue time of our next task, since we did i++ before
                 * our i is at next task already
                 */
                time = newTasks[i][0];
            }
        }

        return result1;
    }
}
