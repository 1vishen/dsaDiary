class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> sol = new ArrayList<>();
        int maxNow = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= maxNow) {
                maxNow = arr[i];
                sol.add(maxNow);
            }
        }

        Collections.reverse(sol);
        return sol;
    }
}