class Solution {
    public String decodeString(String s) {
        /* need to use stack cause encoded can be embedded eg.3a[2b2[c]] */

        Deque<Integer> kStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int k = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch >= '0' && ch <= '9') {
                // build k
                k = k * 10 + ch - '0';
            }
            else if(ch == '[') {
                /* push all collected k and str onto stack and reset both */
                kStack.addLast(k);
                k = 0;
                strStack.addLast(sb.toString());
                sb = new StringBuilder();
            }
            else if(ch >= 'a' && ch <= 'z') {
                // build str
                sb.append(ch);
            }
            else if(ch == ']') {
                /*
                Example a2[bc]:
                strPopped = "a" (prev string before [)
                strCurrent = "bc" (inside brackets), k=2
                Correct: strPopped + strCurrent.repeat(k) = "a" + "bcbc" = "abcbc"
                Wrong: strCurrent.repeat(k) + strPopped = "bcbca"
                */

                int kPopped = kStack.pollLast();
                String strPopped = strStack.pollLast();
                String strCurrent = sb.toString();
                // set sb length to 0 to clear sb for any prev values
                sb.setLength(0);
                sb.append(strPopped).append(strCurrent.repeat(kPopped));
            }
        }
        return sb.toString();
    }
}
