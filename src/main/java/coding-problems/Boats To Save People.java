class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /* logic is we sort the array then track heaviest and lightest person, if heaviest 
        cant pair with lightest then he has to go alone and we move right ptr 1 place and
        increase no of boats by one, we should only move left ptr when it can be paired with 
        right ptr's person */

        Arrays.sort(people);

        int left = 0, right = people.length - 1;
        int boats = 0;

        /* we need = cause in odd cases 1 person will be left without saving & in
        even cases when last 2 remaining are greater than limit*/
        while(left <= right) {
            /* taking care of when both ptr pointing to same element in odd cases & in
            even cases when last 2 remaining are greater than limit */
            if(left == right) {
                boats++;
                break;
            }
            else if(people[left] + people[right] <= limit) {
                boats++;
                left++;
                right--;
            }
            // assuming people[right] <= limit, when people[left] + people[right] > limit 
            else {
                boats++;
                right--;
            }
        }
        return boats;
    }
}
