class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // we can use 2 pointers
        int pAbility = 0, tCapacity = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);

        while(pAbility < players.length && tCapacity < trainers.length) {
            if(players[pAbility] <= trainers[tCapacity]) {
                pAbility++;
            }
            tCapacity++;
        }
        return pAbility;
    }
}
