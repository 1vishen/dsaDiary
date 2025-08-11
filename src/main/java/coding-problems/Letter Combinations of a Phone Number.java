class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        result.add(""); // needed cause we are iterating over result later
        if (digits.length() == 0)
            return new ArrayList<>();

        String[] map = {
                "", // 0
                "", // 1
                "abc", // 2
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        for (int i = 0; i < digits.length(); i++) {
            String charsMapped2Digit = map[digits.charAt(i) - '0'];
            List<String> temp = new ArrayList<>();
            for (String alreadyMade : result) {
                for (char oneChar : charsMapped2Digit.toCharArray()) {
                    temp.add(alreadyMade + oneChar);
                }
            }
            result = temp; //everytime we update result with fresh, longer list
        }
        return result;
    }
}