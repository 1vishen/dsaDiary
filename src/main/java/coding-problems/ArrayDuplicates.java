class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        // code here
        List<Integer> dup = new ArrayList<>();
        Arrays.sort(arr);
        if (arr.length <= 1)
            return dup;
        else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    if (dup.isEmpty() || dup.get(dup.size() - 1) != arr[i]) {
                        dup.add(arr[i]);
                    }
                }
            }
            return dup;
        }
    }
}