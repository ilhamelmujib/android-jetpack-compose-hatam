package org.hatam.android.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.hatam.android.model.Feed
import org.hatam.android.utils.DummyData

class FeedRepository {

    fun getFeeds(): Flow<List<Feed>> {
        return flowOf(DummyData.feeds)
    }

    companion object {
        @Volatile
        private var instance: FeedRepository? = null

        fun getInstance(): FeedRepository =
            instance ?: synchronized(this) {
                FeedRepository().apply {
                    instance = this
                }
            }
    }

}