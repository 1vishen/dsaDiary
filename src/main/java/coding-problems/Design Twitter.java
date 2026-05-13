class Twitter {
    /*
     * i will make a list that stores all tweet i'd globally
     * since insertion order == posting order we dont need a timestamp
     * variable, the int[] format : [tweetid, userid]
     */
    List<int[]> globalTweetList = new ArrayList<>();

    /*
     * a map for each userid to track their following, set for following
     * because we done want a followee to be added more than once
     */
    Map<Integer, Set<Integer>> userFollowing = new HashMap<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        // add to globalTweetList to post the tweet
        globalTweetList.add(new int[] { tweetId, userId });
    }

    public List<Integer> getNewsFeed(int userId) {
        /*
         * from globalTweetList we just have to fetch latest 10 tweets filtered
         * by userid
         */
        List<Integer> result = new ArrayList<>();
        int n = 0;
        // iterator based for each loop
        for (int i = globalTweetList.size() - 1; i >= 0; i--) {
            int[] tweet = globalTweetList.get(i);

            if (n < 10) {
                /*
                 * for each user we need their own tweet and all people who the
                 * user follows
                 */
                // since both tweet[1], userid are primitive int we can use ==
                /*
                 * userFollowing.contains(userid) to avoid
                 * nullptrexception, userFollowing.get(userid).contains(tweet[1]))
                 * contains is on a set so its nearly O(1)
                 */
                if (tweet[1] == userId || (userFollowing.containsKey(userId) &&
                        userFollowing.get(userId).contains(tweet[1]))) {
                    result.add(tweet[0]);
                    n++;
                }
            }
            /*
             * once we have 10 tweets we break, if globalTweetList has less
             * than 10 elements the loop will end automatically
             */
            else
                break;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (userFollowing.containsKey(followerId) == false) {
            userFollowing.put(followerId, new HashSet<>());
            userFollowing.get(followerId).add(followeeId);
        } else
            userFollowing.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // if a userid has no following then unfollow is invalid
        if (userFollowing.containsKey(followerId) == true) {
            userFollowing.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
