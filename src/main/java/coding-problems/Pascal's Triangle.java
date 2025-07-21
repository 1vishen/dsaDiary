class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<>();

        int[][] result = new int[numRows][]; //jagged array
        for(int i = 0; i < numRows; i++){
            result[i] = new int[i + 1]; // creating jagged array cols with variable length
        }

        if(numRows > 0){
            for(int i = 0; i < numRows; i++){
                result[i][0] = result[i][result[i].length - 1] = 1;
                //{1,_,...,_,1}
                for(int j = 1; j < result[i].length - 1; j++){
                    result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
                }
            }
        }

        List<List<Integer>> resultFinal = new ArrayList<>();
        for(int[] col : result){
            List<Integer> resultCol = new ArrayList<>();
            for(int num : col){
                resultCol.add(num);
            }
            resultFinal.add(resultCol);
        }
        return resultFinal;
    }
}