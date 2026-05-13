class Solution {
    public String longestDiverseString(int a, int b, int c) {
        /*
         * we will create a max heap and will try to move char with max freq first
         * if that violates the more than a, aa rule then move on to next highest freq
         * char
         */

        /*
         * LeetCode auto-imports java.util.*, but nested classes like SimpleEntry
         * aren’t exposed. Use fully qualified name:
         * new java.util.AbstractMap.SimpleEntry<>(key, value).
         */

        // making max heap
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a1, b1) -> {
                    return Integer.compare(b1.getValue(), a1.getValue());
                });

        // filling heap
        // Only add characters with a count > 0 to the heap.
        if (a > 0)
            maxHeap.offer(new java.util.AbstractMap.SimpleEntry<>('a', a));
        if (b > 0)
            maxHeap.offer(new java.util.AbstractMap.SimpleEntry<>('b', b));
        if (c > 0)
            maxHeap.offer(new java.util.AbstractMap.SimpleEntry<>('c', c));

        // main logic
        StringBuilder result = new StringBuilder();
        while (maxHeap.isEmpty() == false) {
            Map.Entry<Character, Integer> maxEntry = maxHeap.poll();

            // // need to check if last 2 chars are same as maxEntry
            if ((result.length() >= 2) &&
                    (result.charAt(result.length() - 1) == maxEntry.getKey()) &&
                    (result.charAt(result.length() - 2) == maxEntry.getKey())) {
                /*
                 * do i have sec entry to use? or not after polling max entry, if not
                 * then break from loop
                 */
                if (maxHeap.isEmpty() == true)
                    break;

                Map.Entry<Character, Integer> secEntry = maxHeap.poll();
                result.append(secEntry.getKey());
                secEntry.setValue(secEntry.getValue() - 1);

                if (secEntry.getValue() > 0)
                    maxHeap.offer(secEntry);
                // also put back unused maxEntry
                maxHeap.offer(maxEntry);
            } else {
                result.append(maxEntry.getKey());
                maxEntry.setValue(maxEntry.getValue() - 1);

                // check freq of max entry and put it back
                if (maxEntry.getValue() > 0)
                    maxHeap.offer(maxEntry);
            }
        }

        return result.toString();
    }
}
