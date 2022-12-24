package org.hatam.android.ui.screen.feed

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

class FeedViewModel(
    private val feedRepository: FeedRepository,
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Feed>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Feed>>>
        get() = _uiState

    fun getFeeds() {
        viewModelScope.launch {
            feedRepository.getFeeds().catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect {
                _uiState.value = UiState.Success(it)
            }
        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return FeedViewModel(provideFeedRepository()) as T
            }
        }
    }

}