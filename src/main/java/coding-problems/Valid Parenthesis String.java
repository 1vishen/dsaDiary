class Solution {
    public boolean checkValidString(String s) {
        /*
         * We track a range of unmatched '(' using minOpen and maxOpen:
         * - minOpen = minimum possible opens left if every '*' is treated as ')' or
         * empty.
         * - maxOpen = maximum possible opens left if every '*' is treated as '('.
         * Every '(' increases both, every ')' decreases both, and every '*' decreases
         * minOpen (acting as ')') while increasing maxOpen (acting as '(').
         * By maintaining this range, we implicitly account for how many '*' are
         * available
         * to balance parentheses and ensure validity.
         */

        int minOpen = 0, maxOpen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            /*
             * Ordering is enforced by maxOpen: if it drops below 0, too many ')'
             * appeared.
             */

            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--;
                maxOpen++;
            }

            // if maxOpen drops below 0 that means we have too many )
            if (maxOpen < 0)
                return false;
            /*
             * if minOpen drops below 0 that means treating all * as ) can cause more )
             * than ( but we reset it to 0 cause there exists a sol where we convert some
             * less number of * to ) than to convert all * to ) to find a solution
             */
            minOpen = Math.max(minOpen, 0);
        }
        /*
         * if minOpen remains 0 that means we have found a sol where ( and ) are
         * perfectly balanced, if minOpen > 0, then even treating all * as ) isn’t
         * enough
         * to balance.
         */
        if (minOpen == 0)
            return true;
        return false;
    }
}
