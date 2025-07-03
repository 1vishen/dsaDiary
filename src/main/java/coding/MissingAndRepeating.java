// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> soln = new ArrayList<>();
        int n = arr.length;
        int duplicate = -1, missing = -1;
        int[] freq = new int[n + 1];

        for (int num : arr) {
            freq[num]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2)
                duplicate = i;
            if (freq[i] == 0)
                missing = i;
        }
        soln.add(duplicate);
        soln.add(missing);
        return soln;

    }
}