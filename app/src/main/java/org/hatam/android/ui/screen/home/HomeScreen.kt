package org.hatam.android.ui.screen.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.hatam.android.ui.common.UiState
import org.hatam.android.ui.components.*

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = HomeViewModel.provideFactory()
    ),
    navigateToFeed: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(
        initial = UiState.Loading
    ).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllData()
            }
            is UiState.Success -> {
                LazyColumn(modifier = modifier) {
                    item {
                        ShariaPoint()
                        HomeMenu()
                        SahamQu()
                        Spacer(modifier = Modifier.height(15.dp))
                        VideoRow(uiState.data.videos)
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                    items(uiState.data.feeds, key = { it.id }) {
                        FeedItem(it, {
                            navigateToFeed(it.id.toLong())
                        })
                    }
                }
            }
            is UiState.Error -> {}
        }
    }
}
