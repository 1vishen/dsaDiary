class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        /* Used sliding window (i to i+10) to extract fixed-length substrings efficiently 
        without extra logic. */
        /* Chose two sets over map since we only care about presence, not frequency — simpler
         and space-friendly. */

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for(int i = 0; i < s.length() - 9; i++) {
            String dnaSeq = s.substring(i, i + 10);

            /* if seen set contains this seq that means it occurs more than once, and we can
             add it to results */
            if(seen.contains(dnaSeq)) {
                duplicates.add(dnaSeq);
            }
            else {
                seen.add(dnaSeq);
            }
        }
        return new ArrayList<String>(duplicates);

    }
}
