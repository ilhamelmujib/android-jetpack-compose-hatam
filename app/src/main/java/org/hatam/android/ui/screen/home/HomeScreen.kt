package org.hatam.android.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.hatam.android.ui.common.UiState
import org.hatam.android.ui.components.*
import org.hatam.android.ui.theme.AllNewHatamTheme
import org.hatam.android.utils.DummyData

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = HomeViewModel.provideFactory()
    ),
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar()
        }
    ) {
        Column(modifier = modifier.padding(it)) {
            ShariaPoint()
            HomeMenu()
            SahamQu()
            Spacer(modifier = Modifier.height(15.dp))
            viewModel.uiState.collectAsState(
                initial = UiState.Loading
            ).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getAllData()
                    }
                    is UiState.Success -> {
                        VideoRow(uiState.data.videos)
                    }
                    is UiState.Error -> {}
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AllNewHatamTheme {
        Column {
            HomeScreen()
            VideoRow(DummyData.videos)
        }
    }
}