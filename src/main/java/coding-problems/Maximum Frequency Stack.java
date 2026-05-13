class FreqStack {
    /*
     * Heap approach idea: Use PriorityQueue storing (val, freq, order) triples,
     * comparator sorts by freq then order. On push: increment freq, insert new
     * triple with updated order; on pop: remove top, decrement freq, reinsert if
     * still >0. Time Complexity: Push = O(log n), Pop = O(log n) due to heap
     * operations. Slower than HashMap+Stack (O(1) push/pop) because heap requires
     * reheapify and reinsertion each time.
     */

    // one hashmap that stores freq -> stack of values with same freq
    HashMap<Integer, ArrayDeque<Integer>> freqStackMap;
    // 2nd hashmap to store freq of single emenent (element -> freq)
    HashMap<Integer, Integer> valFreqMap;
    // a var to track current max freq
    int maxFreq;

    public FreqStack() {
        freqStackMap = new HashMap<>();
        valFreqMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        // first push val and increase freq in element->freq map
        valFreqMap.put(val, valFreqMap.getOrDefault(val, 0) + 1);
        int freq = valFreqMap.get(val);
        // if this freq is bigger than maxFreq we update
        maxFreq = Math.max(maxFreq, freq);

        /*
         * then we update freq->stack map, since we are using stack to store
         * all elements with same freq (tie) we dont need to wory as stack will
         * take care of tie breaker requirement
         */
        if (freqStackMap.get(freq) == null) {
            freqStackMap.put(freq, new ArrayDeque<>(List.of(val)));
        } else {
            freqStackMap.get(freq).push(val);
        }
    }

    public int pop() {
        // first store the element to be popped
        int popped = freqStackMap.get(maxFreq).pop();
        // also after we pop we need to remove stack if it becomes empty
        if (freqStackMap.get(maxFreq).isEmpty() == true) {
            freqStackMap.remove(maxFreq);
        }
        /*
         * we need to update maxFreq to make sure it always points to max freq.
         * Frequencies increase one step at a time, so if freq=10 exists then
         * freq=9 must exist. maxFreq only ever drops by 1 after a pop.
         */
        if (freqStackMap.get(maxFreq) == null)
            maxFreq--;

        // now we decrease freq of this element in element->freq map
        valFreqMap.put(popped, valFreqMap.get(popped) - 1);
        int newFreq = valFreqMap.get(popped);
        /*
         * No need to push into lower freq stack again after pop. Element was
         * already added there during earlier pushes, reinserting would cause
         * duplicates.
         */
        return popped;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
