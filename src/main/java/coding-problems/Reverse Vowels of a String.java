class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        Set<Character> vowelSet = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int leftPointer = 0, rightPointer = sb.length() - 1;

            while(leftPointer < rightPointer) {
                if(!vowelSet.contains(sb.charAt(leftPointer))) {
                    leftPointer++;

                }
                else {
                    if(!vowelSet.contains(sb.charAt(rightPointer))) {
                        rightPointer--;
                    }
                    else {
                        char chTemp = sb.charAt(leftPointer);
                        sb.setCharAt(leftPointer, sb.charAt(rightPointer));
                        sb.setCharAt(rightPointer, chTemp);
                        leftPointer++;
                        rightPointer--;
                    }
                }   
            }
            return sb.toString();
    }
}