class Solution {
    public List<Integer> getRow(int rowIndex) {
        //constructing pascal triangle nth row: a_{k+1} = a_k * (n - k) / k
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if(rowIndex > 0){
            for(int k = 1; k <= rowIndex; k++){
                long prev = result.get(k - 1);
                long next = prev * (rowIndex + 1 - k) / k;
                result.add((int) next);
            }
        }
        return result;
    }
}