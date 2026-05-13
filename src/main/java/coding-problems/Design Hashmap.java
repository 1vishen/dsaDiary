class MyHashMap {
    /*
     * main objective of hashing function is not to prevent duplicates its job
     * is to spread keys in buckets of almost equal sizes, so we need to divide
     * key by a number which gives remainder of equal spacing in between and is
     * big enough to make enough buckets so that a bucket doesnt get big enough,
     * eg. 1009
     */
    List<List<int[]>> buckets;

    public MyHashMap() {
        // 1009 Buckets cause remainder of 1009 can be anywhere from 0 to 1008
        buckets = new ArrayList<>(1009);
        for (int i = 0; i < 1009; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public void put(int key, int value) {
        int bucketIndex = key % 1009;

        // check if duplicate key is there
        List<int[]> bucket = buckets.get(bucketIndex);
        boolean duplicate = false;
        for (int i = 0; i < bucket.size(); i++) {
            int[] pair = bucket.get(i);
            if (pair[0] == key) {
                duplicate = true;
                // if dup found then replace val with new val
                pair[1] = value;
                break;
            }
        }
        // if no dup then add teh key val pair as int[]
        if (duplicate == false)
            bucket.add(new int[] { key, value });
    }

    public int get(int key) {
        int bucketIndex = key % 1009;
        List<int[]> bucket = buckets.get(bucketIndex);

        for (int[] pair : bucket) {
            if (pair[0] == key)
                return pair[1];
        }
        return -1;
    }

    public void remove(int key) {
        int bucketIndex = key % 1009;
        List<int[]> bucket = buckets.get(bucketIndex);
        /*
         * since arrays dont implement equals() so we can’t just call
         * bucket.remove(new int[]{key, value}) we need to find index of the key val
         * pair
         */
        for (int i = 0; i < bucket.size(); i++) {
            int[] pair = bucket.get(i);
            if (pair[0] == key) {
                bucket.remove(i);
                // return immediately after removing to avoid further iterating
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
