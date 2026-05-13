class StockSpanner {
    /*
     * n the brute force approach, I store all past prices in a list. For each
     * new price, I scan backward until I hit a larger price, counting consecutive
     * days less than or equal to today’s price. The span returned is this count
     * plus today itself, with a time complexity of O(n) per query and O(n²)
     * overall.
     */

    /*
     * in my optimal approach, i will use a stack and i will store [price, span]
     * so that span is availabe all the time and we dont need to iterate all time,
     * so before inserting i compare prices and adjust span accordingly
     */
    ArrayDeque<int[]> priceData;

    public StockSpanner() {
        priceData = new ArrayDeque<>();
    }

    public int next(int price) {
        if (this.priceData.isEmpty() == true)
            priceData.push(new int[] { price, 1 });
        else {
            if (price >= this.priceData.peek()[0]) {
                int span = 1;
                /*
                 * we keep popping till current price >= top price and add top
                 * price's span to our span
                 */
                while (this.priceData.isEmpty() == false &&
                        price >= this.priceData.peek()[0]) {
                    /*
                     * .poll() permanently deletes smaller past prices so future days
                     * never double-count them. span += pair[1] absorbs their history into
                     * the current price before they are destroyed.
                     */
                    int[] pair = this.priceData.poll();
                    span += pair[1];
                }
                this.priceData.push(new int[] { price, span });
            }
            // else we reset span
            else
                this.priceData.push(new int[] { price, 1 });
        }

        // return final span
        return this.priceData.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
