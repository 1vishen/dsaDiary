class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        /*
         * At each index we must check forward (within [i+minJump, i+maxJump])
         * to see if new zeros can be reached, and backward to confirm that the
         * current index itself was reachable. Gap-counting alone fails because
         * it ignores this chain of connectivity, while the sliding window ensures
         * only truly reachable zeros are added to the path.
         */
        // we can stop recounting all eligible indexes prev encountered by using a set
        if (s.charAt(0) == '1')
            return false;
        Set<Integer> alreadyVisited = new HashSet<>();
        // 1st index always reachable
        alreadyVisited.add(0);

        int farthest = 0;
        for (int i = 0; i < s.length(); i++) {
            // check if current i is reachable from prev index
            if (alreadyVisited.contains(i)) {
                // incl all indexes that can be reached from i

                /*
                 * we need to respect minJump so if its greater than farthest then
                 * we need to start from it but doing this will allow us to skip all the
                 * indexes that we have already included, also we need to stop j before
                 * if i + maxJump exceeds str length
                 */
                for (int j = Math.max(farthest + 1, i + minJump); j <= Math.min(i + maxJump, s.length() - 1); j++) {
                    char c2 = s.charAt(j);

                    if (c2 == '0')
                        alreadyVisited.add(j);

                    // if j reaches last element then its possible to jump all the way
                    if (j == s.length() - 1 && s.charAt(j) == '0')
                        return true;
                }
                // update farthest
                farthest = Math.min(i + maxJump, s.length() - 1);
            }

        }
        /*
         * if we reached end without ever reaching j == last element then that means
         * its not possible
         */
        return false;
    }
}
