package org.hatam.android.di

import org.hatam.android.data.FeedRepository
import org.hatam.android.data.VideoRepository


object Injection {
    fun provideVideoRepository(): VideoRepository {
        return VideoRepository.getInstance()
    }

    fun provideFeedRepository(): FeedRepository {
        return FeedRepository.getInstance()
    }
}