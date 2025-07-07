
class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
        Map<Integer, Integer> freqA = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            freqA.put(a[i], freqA.getOrDefault(a[i], 0) + 1);
        }
        for(int num : b) {
            if(!freqA.containsKey(num) || freqA.get(num) == 0){
                return false;
            }
                freqA.put(num, freqA.get(num) - 1);
        }
        return true;
    }
}