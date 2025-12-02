class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // similar to 875. Koko Eating Bananas
        /* unlike koko Qs we cannot split a package across days or reorder
        packages, when packages exceed capacity we must stop for that day */

        /* finding maxC, max cap of ship will be a ship that can carry
        everything at once in 1 day */
        int maxC = 0, minC = weights[0];
        for(int n : weights) {
            maxC += n;
            /* minC will be a ship that takes longest days i.e. it carries 
            each package 1 by 1 so its capacity must be == max weight in
            the arr so that it can carry every weight 1 by 1*/
            minC = Math.max(minC, n);
        }

        // binary search to find least cap ship
        int left = minC, right = maxC;
        int result = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int totalDays = giveTotalDays(mid, weights, days);

            if(totalDays <= days) {
                result = mid;
                // to find a valid mid lower than current
                right = mid - 1;
            }
            else if(totalDays > days) {
                left = mid + 1;
            }
        }
        return result;
    }

    public int giveTotalDays(int capacity, int[] arr, int days) {
        // countDays = 1 cause a max cap ship can carry everything in 1 day
        int totalCapacity = 0, countDays = 1;
        for(int weight : arr) {
            if(totalCapacity + weight > capacity) {
                countDays++;
                /* if adding current weight exceeds capacity then come to next
                day and add current weight to next day since this when added
                exceeded the capapcity */
                totalCapacity = weight;
            }
            else {
                totalCapacity += weight;
            }
            // if countDays exceeds given days then that capacity is invalid
            if(countDays > days) return countDays;
        }
        return countDays;
    }
}