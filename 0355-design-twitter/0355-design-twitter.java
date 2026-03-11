class Twitter {
    private static int timeStamp = 0;
    private class User{
        Set<Integer> followed;
        int userId;
        Tweet tweetHead;
        public User(int id){
            this.userId = id;
            this.followed = new HashSet<>();
            follow(id);
            this.tweetHead = null;
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            followed.remove(id);
        }
        public void post(int id){
            Tweet latestTweet = new Tweet(id);
            latestTweet.nextTweet = tweetHead;
            tweetHead = latestTweet;
        }
    }
    private class Tweet{
        int tweetId;
        int tweetTime;
        Tweet nextTweet;
        public Tweet(int id){
            this.tweetId = id;
            this.tweetTime = timeStamp++;
            nextTweet = null;
        }
    }
    private Map<Integer, User> userMap;
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return ans;
        }
        User user = userMap.get(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2)-> t2.tweetTime- t1.tweetTime);
        for(int id: user.followed){
            User u = userMap.get(id);
            if(u.tweetHead!=null){
                pq.add(u.tweetHead);
            }
        }
        while(ans.size()<10 && !pq.isEmpty()){
            Tweet t = pq.poll();
            ans.add(t.tweetId);
            if(t.nextTweet!=null){
                pq.add(t.nextTweet);
            }
        }
        return ans;

    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u );
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u );
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId == followeeId){
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
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