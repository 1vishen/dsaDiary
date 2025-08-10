class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean direction = true;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(direction == true) {
                rows.get(currentRow).append(ch);
                currentRow++;
            }
            else {
                rows.get(currentRow).append(ch);
                currentRow--;
            }

            if(currentRow <= 0) {
                direction = true;
            }
            if(currentRow >= numRows - 1) {
                direction = false;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            result.append(rows.get(i));
        }
        return result.toString();
    }
}