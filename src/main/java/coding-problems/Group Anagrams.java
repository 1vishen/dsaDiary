class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        if (strs.length == 0) return new ArrayList<List<String>>();

        for(int i = 0; i < strs.length; i++) {
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String sortedWord = String.valueOf(word);

            group.putIfAbsent(sortedWord, new ArrayList<>());
            /* if it didnt put then it means that particular sorted word key is
                already there so just need to add word to corresponding arraylist
                and as each anagram will have same sorted word key so we'll get our
                final list of list of strings */
            group.get(sortedWord).add(strs[i]); //can use add cause it get returns an arraylist
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> sublist : group.values()) {
            result.add(sublist);
        }
        return result;
    }
}ß