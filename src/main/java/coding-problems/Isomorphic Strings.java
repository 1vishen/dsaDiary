class Solution {
    public boolean isIsomorphic(String s, String t) {
        //if we do arr[a] it will interpret it as its ascii value
        if(s.length() != t.length()) return false;
        int[] map1 = new int[200]; //to accomodate all ascii values + some buffer
        int[] map2 = new int[200];

        for(int i = 0; i < s.length(); i++){
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) return false;

            //increment both by same amount, the amount doesnt matter, same-ness matters
            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}