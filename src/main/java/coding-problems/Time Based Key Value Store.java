class TimeMap {
    /*
     * if all timestamp are increasing strictly that means no two are equal and
     * its sorted already
     */
    Map<String, List<Map.Entry<Integer, String>>> map1;

    public TimeMap() {
        map1 = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (map1.get(key) == null) {
            map1.put(key, new ArrayList<>(
                    List.of(new java.util.AbstractMap.SimpleEntry<>(timestamp, value))));
        } else {
            map1.get(key).add(
                    new java.util.AbstractMap.SimpleEntry<>(timestamp, value));
        }
    }

    public String get(String key, int timestamp) {
        /*
         * if timestamp is present then simply return the value if not we return
         * value of timestamp smaller but closest to timestamp asked as parameter
         */
        // we can use a binary search to achieve this
        if (map1.get(key) == null)
            return "";

        List<Map.Entry<Integer, String>> tempList = map1.get(key);
        int left = 0, right = tempList.size() - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            Map.Entry<Integer, String> pair = tempList.get(mid);
            // we can use == cause timestamp and pair.getKey() both are integers
            if (pair.getKey() == timestamp)
                return pair.getValue();
            else if (timestamp < pair.getKey())
                right = mid - 1;
            else
                left = mid + 1;
        }
        /*
         * if we reach here that means left > right and timestamp is not in list
         * then we need to return smallest timestamp, which would be where right is.
         * also if timestamp in parameter is smaller than first timestamp then
         * right will be -1 and we need ""
         */
        return (right == -1) ? "" : tempList.get(right).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
