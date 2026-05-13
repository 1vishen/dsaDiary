class MyHashSet {
    /*
     * hash function’s job isn’t to prevent duplicates, it’s to spread values
     * across buckets so lookups are fast. so we need to create buckets and divide
     * all by a number that outputs remainder evenly
     */

    // declaring bucket
    List<List<Integer>> bucket;

    public MyHashSet() {
        // initializing bucket
        bucket = new ArrayList<>(1009);

        /*
         * initializing all indices of bucket cause List.get(index) never returns
         * null just because the list is empty. Instead, it throws an
         * IndexOutOfBoundsException if you try to access an index that doesn’t
         * exist.
         */
        // initially bucket size is 0 so to make loop run we do i < 1009
        for (int i = 0; i < 1009; i++) {
            bucket.add(new ArrayList<>());
        }

    }

    public void add(int key) {
        // hashing func
        /*
         * we are using remainders and indexes so we need to control inner list
         * size we need a number that vary but not so much, 1009 will do cause if
         * bucket_count is too small (say 7), then many keys will collide into the
         * same bucket, and those inner lists will grow long. That makes lookups
         * slower. If bucket_count is larger (say 1000), collisions are less
         * frequent, so each inner list stays short. That keeps operations close to
         * O(1).
         */
        int index = key % 1009;

        // handling duplicates
        boolean dup = false;
        List<Integer> buck = bucket.get(index);
        for (int i = 0; i < buck.size(); i++) {
            if (buck.get(i).equals(key)) {
                dup = true;
                break;
            }
        }
        // if it makes here that means we dont ahve any duplicates
        if (dup == false)
            buck.add(key);
    }

    public void remove(int key) {
        // index hash will always be same and needs to be same
        int index = key % 1009;
        /*
         * need to tell Java explicitly that you want to remove the object (the
         * value), not the index. Do this by casting:
         */
        bucket.get(index).remove((Integer) key);
    }

    public boolean contains(int key) {
        int index = key % 1009;
        List<Integer> buck = bucket.get(index);

        for (int i = 0; i < buck.size(); i++) {
            // in Java, == compares object references, not values
            if (buck.get(i).equals(key)) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
