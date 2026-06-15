class Twitter {
    val followers = mutableSetOf<Pair<Int, Int>>()
    val tweets = mutableListOf<Pair<Int, Int>>()

    fun postTweet(userId: Int, tweetId: Int) {
        tweets.add(Pair(userId, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val newsList = mutableListOf<Int>()
        var i = tweets.size - 1
        while(i >= 0 && newsList.size < 10){
            if(tweets.get(i).first == userId || followers.contains(Pair(userId, tweets.get(i).first))){
                newsList.add(tweets.get(i).second)
            }
            i--
        }
        return newsList
    }

    fun follow(followerId: Int, followeeId: Int) {
        followers.add(Pair(followerId, followeeId))
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followers.remove(Pair(followerId, followeeId))
    }
}
