class Solution {
    public boolean lemonadeChange(int[] bills) {
        /*
         * keep a track of bills and always give change starting from the largest
         * denomination first so smaller bills remain available
         */
        // no count20 cause we will never use it to give back
        int count5 = 0, count10 = 0;

        for (int i = 0; i < bills.length; i++) {
            int b = bills[i];

            if (b == 5)
                count5++;
            else if (b == 10) {
                if (count5 > 0) {
                    count10++;
                    count5--;
                } else
                    return false;
            } else if (b == 20) {
                // count20++;
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                } else if (count5 >= 3)
                    count5 -= 3;
                else
                    return false;
            }
        }
        return true;
    }
}
