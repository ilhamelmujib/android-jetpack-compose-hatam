package org.hatam.android.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.hatam.android.model.Video
import org.hatam.android.utils.DummyData

class VideoRepository {

    fun getVideos(): Flow<List<Video>> {
        return flowOf(DummyData.videos)
    }

    companion object {
        @Volatile
        private var instance: VideoRepository? = null

        fun getInstance(): VideoRepository =
            instance ?: synchronized(this) {
                VideoRepository().apply {
                    instance = this
                }
            }
    }

}