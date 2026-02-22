class Solution {
    public String reorganizeString(String s) {
        /*
         * if we have enough freq of smaller freq elements specifically freq of current
         * element should be only 1 more than freq of smaller elements combined
         */

        // calc freq and sorting by freq desc
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));
        Map<Character, Integer> entryAll = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            entryAll.put(c, entryAll.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : entryAll.entrySet()) {
            maxHeap.offer(entry);
        }

        /* if theres 1 char left in heap with some freq > 0, thrn not possible */

        StringBuilder sb = new StringBuilder();
        while (maxHeap.isEmpty() == false) {
            Map.Entry<Character, Integer> e1 = maxHeap.poll();
            sb.append(e1.getKey());
            e1.setValue(e1.getValue() - 1);

            /*
             * if after polling e1 and appending it heap becomes empty, we check if e1
             * still has freq > 0 if yes then its not possible to form the string
             */
            if (maxHeap.isEmpty() == true && e1.getValue() > 0)
                return "";
            if (maxHeap.isEmpty() == true && e1.getValue() == 0)
                break;

            Map.Entry<Character, Integer> e2 = maxHeap.poll();
            sb.append(e2.getKey());
            e2.setValue(e2.getValue() - 1);

            if (e1.getValue() > 0)
                maxHeap.offer(e1);
            if (e2.getValue() > 0)
                maxHeap.offer(e2);
        }
        return sb.toString();

    }
}
