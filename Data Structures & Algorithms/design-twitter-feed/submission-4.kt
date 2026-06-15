class Twitter {
    val followers = mutableMapOf<Int, MutableSet<Int>>()
    val tweets = mutableMapOf<Int, MutableList<Pair<Int,Int>>>()
    var timestamp = 0
    
    fun postTweet(userId: Int, tweetId: Int) {
        // Korisnik automatski prati samog sebe da bi video svoje tvitove u feed-u
        followers.getOrPut(userId) { mutableSetOf() }.add(userId)
        
        tweets.getOrPut(userId) { mutableListOf() }.add(Pair(tweetId, ++timestamp))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        // Max-Heap koji poredi tvitove prema timestamp-u
        val maxHeap = PriorityQueue<IntArray> { a, b -> b[0] - a[0] }

        // Pošto korisnik prati i samog sebe, ovde hvatamo i njegove tvitove i tvitove ljudi koje prati
        followers[userId]?.forEach { followeeId ->
            val fTweets = tweets[followeeId]
            if (fTweets != null && fTweets.isNotEmpty()) {
                val lastIdx = fTweets.size - 1
                maxHeap.offer(intArrayOf(fTweets[lastIdx].second, fTweets[lastIdx].first, followeeId, lastIdx - 1))
            }
        }

        val result = mutableListOf<Int>()

        // Izvlačimo do 10 najnovijih jedinstvenih tvitova
        while (maxHeap.isNotEmpty() && result.size < 10) {
            val curr = maxHeap.poll()
            val tweetId = curr[1]
            val tweetOwnerId = curr[2]
            val nextIdx = curr[3]

            result.add(tweetId)

            if (nextIdx >= 0) {
                val list = tweets[tweetOwnerId]!!
                maxHeap.offer(intArrayOf(list[nextIdx].second, list[nextIdx].first, tweetOwnerId, nextIdx - 1))
            }
        }

        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        // Dozvoljavamo normalno praćenje
        followers.getOrPut(followerId) { mutableSetOf() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        // Korisnik ne sme da otprati samog sebe, inače neće videti svoje tvitove
        if (followerId == followeeId) return
        
        followers[followerId]?.let { set ->
            set.remove(followeeId)
            if (set.isEmpty()) {
                followers.remove(followerId) 
            }
        }
    }
}
