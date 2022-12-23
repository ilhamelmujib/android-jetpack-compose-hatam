package org.hatam.android.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.hatam.android.data.FeedRepository
import org.hatam.android.data.VideoRepository
import org.hatam.android.di.Injection.provideFeedRepository
import org.hatam.android.di.Injection.provideVideoRepository
import org.hatam.android.model.Feed
import org.hatam.android.model.Video
import org.hatam.android.ui.common.UiState

data class HomeUiState(
    val videos: List<Video> = emptyList(),
    val feeds: List<Feed> = emptyList()
)

class HomeViewModel(
    private val videoRepository: VideoRepository,
    private val feedRepository: FeedRepository,
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<HomeUiState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<HomeUiState>>
        get() = _uiState

    fun getAllData() {
        viewModelScope.launch {
            val videos = async { videoRepository.getVideos() }
            val feeds = async { feedRepository.getFeeds() }

            var collectVideos = emptyList<Video>()
            var collectFeeds = emptyList<Feed>()

            videos.await().catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect {
                collectVideos = it
            }

            feeds.await().catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect {
                collectFeeds = it
            }

            _uiState.value = UiState.Success(HomeUiState(collectVideos, collectFeeds))

        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(provideVideoRepository(), provideFeedRepository()) as T
            }
        }
    }

}