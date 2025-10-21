class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0)
            return "";
        // remove any leading or training spaces
        s = s.trim();

        StringBuilder result = new StringBuilder();
        String[] parts = s.split("\\s+");

        /* using insert(0, …) repeatedly shifts all the existing characters each time, making it O(n²) in worst case. bad for performance */
        // for (int i = 0; i < parts.length; i++) {
        //     String word = parts[i];
        //     if (i == 0)
        //         result.insert(0, word);
        //     else
        //         result.insert(0, word + " ");
        // }

        for (int i = parts.length - 1; i >= 0; i--) {
            String word = parts[i];
            if (i == 0)
                result.append(word);
            else
                result.append(word + " ");
        }
        return result.toString();
    }
}