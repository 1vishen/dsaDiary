class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\\s+");

        if(arr.length != pattern.length()) return false;

        Map<String, Character> s2p = new HashMap<>();
        Map<Character, String> p2s = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            char pi = pattern.charAt(i);
            String si = arr[i];

            if(s2p.containsKey(si) && s2p.get(si) != pi) return false;
            if(p2s.containsKey(pi) && !p2s.get(pi).equals(si)) return false;
            if(!s2p.containsKey(si)) {
                s2p.put(si, pi);
                p2s.put(pi, si);
            }
        }
        return true;
    }
}