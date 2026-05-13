class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        /*
         * the brute‑force method sorts projects by profit and repeatedly picks
         * the most profitable project affordable with current capital (capital ≤
         * w), Requires rescanning the list each time, leading to O(n·k) time
         * complexity.
         */

        /*
         * a more optimal approach would be to have 2 heaps a min heap from
         * which we can pop all projects whose capital <= our current capital and
         * then a max heap of those popped projects so that we only pick the most
         * profitable one and keep rest in max heap itself since all those still
         * qualify (their captial <= our current capital still) [profits, capital]
         */

        // declaring heaps
        // min‑heap by capital
        PriorityQueue<int[]> allProj = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1]));
        // max‑heap by profit
        PriorityQueue<int[]> qualified = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0]));

        // moving all projects to min heap assuming arr profits always == capital
        for (int i = 0; i < profits.length; i++) {
            allProj.offer(new int[] { profits[i], capital[i] });
        }

        while (k > 0) {
            // move qualified projects to max heap
            while (allProj.isEmpty() == false && allProj.peek()[1] <= w) {
                int[] project = allProj.poll();
                qualified.offer(project);
            }

            // pick the project with max profit from qualified projects
            if (qualified.isEmpty() == false) {
                int[] maxProject = qualified.poll();
                w += maxProject[0];
                k--;
            }
            /*
             * if qualified is empty that means we can start no project with
             * current capital and should exit out of the loop
             */
            else
                break;
        }

        return w;
    }
}
