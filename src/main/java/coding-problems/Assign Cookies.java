class Solution {
    public int findContentChildren(int[] g, int[] s) {
        /* Skip cookies, not children, to find the smallest cookie that satisfies each child's
         greed cause, If a cookie is too small it can't help move to the next one. */
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) i++;
            j++;
        }
        return i;

    }
}
