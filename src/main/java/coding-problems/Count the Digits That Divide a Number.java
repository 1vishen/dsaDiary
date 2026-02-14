class Solution {
    public int countDigits(int num) {
        int y = num;
        List<Integer> digitList = new ArrayList<>();
        while(y != 0){
            int digit = y % 10;
            if(num % digit == 0 && digit != 0) 
            digitList.add(digit);
            y = y / 10;
        }
        return digitList.size();
    }
}