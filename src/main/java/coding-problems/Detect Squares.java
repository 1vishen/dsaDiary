class DetectSquares {
    /*
     * we will be performing a lot of lookups so we cant use 2d arr, we can use map
     * as
     * freq map,
     * 
     * since int[] dont implement equals() so will use Object.equals() which checks
     * for same
     * memory address not elements we need to use list in order to use contains
     * method of map,
     * 
     * also in order to use contains to get all coordinates in same x axis we need
     * to design
     * map such a way that we can use contains with just 1 of the 2 nums in the
     * point
     * coordinate so like Map<x, Map<y, freq>>
     */
    Map<Integer, Map<Integer, Integer>> dataStr = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        // add if value doesnt exists in dataStr
        this.dataStr.putIfAbsent(x, new HashMap<>());

        // for same x, different y values will exist in inner map
        Map<Integer, Integer> inner = this.dataStr.get(x);
        // update freq if already exists
        inner.put(y, inner.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        // 1st coordinate : (x,y)
        int x = point[0];
        int y = point[1];

        int total = 0;

        /*
         * for same x we are looking at all y values and we are using each one of these
         * y with same x as 2nd coordinate and check for square
         */
        // null exception protection
        if (!dataStr.containsKey(x))
            return 0;
        for (Map.Entry<Integer, Integer> entry : dataStr.get(x).entrySet()) {
            // 2nd coordinate : (x,y1)
            int y1 = entry.getKey();
            int freq = entry.getValue();
            int side = Math.abs(y - y1);

            // if y1 same as y ignore it as its the parameter point
            if (y1 == y)
                continue;

            // case 1 : sq to right of (x,y) & (x,y1) line
            int x1 = x + side;

            // 3rd coordinate : (x1,y) so 4th coordinate : (x1,y1) line

            /*
             * Directly calling dataStr.get(x1).get(y) may throw
             * NullPointerException if x1 is missing; use getOrDefault with
             * Collections.emptyMap() for safety.
             */
            total += freq *
                    dataStr.getOrDefault(x1, Collections.emptyMap()).getOrDefault(y, 0) *
                    dataStr.getOrDefault(x1, Collections.emptyMap()).getOrDefault(y1, 0);

            // case 2 : sq to left of (x,y) & (x,y1)
            x1 = x - side;
            total += freq *
                    dataStr.getOrDefault(x1, Collections.emptyMap()).getOrDefault(y, 0) *
                    dataStr.getOrDefault(x1, Collections.emptyMap()).getOrDefault(y1, 0);
        }
        return total;

    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
