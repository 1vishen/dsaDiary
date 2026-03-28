class Solution {
    public String predictPartyVictory(String senate) {
        /*
         * I play multiple rounds of str len or less long and keep track of all
         * senators that can vote and also keep track of no. of D and R members, if at
         * any
         * time one of the two member count becomes 0 i declare other victor
         */

        int noR = 0, noD = 0;
        int[] eligible = new int[senate.length()];

        // counting members of each and eligibility
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c == 'R')
                noR++;
            else if (c == 'D')
                noD++;

            // making all eligible at first
            eligible[i] = 1;
        }

        // main logic
        // the game should run till both R and D have at least 1 senator
        while (noR > 0 && noD > 0) {
            for (int i = 0; i < senate.length(); i++) {
                char c = senate.charAt(i);

                if (eligible[i] == 1) {
                    for (int k = i + 1; k < i + senate.length(); k++) {
                        /*
                         * we need to make a cyclic loop so that it searches from all
                         * available senators
                         */
                        int j = k % senate.length();

                        /*
                         * check if next senator to be banned is from opposite party
                         * and eligible
                         */
                        if (senate.charAt(j) != c && eligible[j] != 0) {
                            eligible[j] = 0;
                            // reduce no of senators
                            if (senate.charAt(j) == 'R')
                                noR--;
                            else if (senate.charAt(j) == 'D')
                                noD--;
                            // break cause we should only ban 1 senator
                            break;
                        }
                    }
                }

                // check if any of the 2 R and D becomes 0;
                if (noR == 0)
                    return "Dire";
                else if (noD == 0)
                    return "Radiant";
            }
        }
        return noR == 0 ? "Dire" : "Radiant";
    }
}
