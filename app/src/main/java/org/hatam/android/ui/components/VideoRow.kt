package org.hatam.android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.hatam.android.model.Video
import org.hatam.android.ui.theme.AllNewHatamTheme
import org.hatam.android.utils.DummyData
import org.hatam.android.utils.getThumbnailYoutube
import org.hatam.android.utils.notNull

@Composable
fun VideoRow(
    videos: List<Video>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(videos, key = { it.id.notNull() }) {
            VideoItem(photoUrl = it.code.getThumbnailYoutube())
        }
    }
}

@Preview
@Composable
fun VideoRowPreview() {
    AllNewHatamTheme {
        VideoRow(videos = DummyData.videos)
    }
}

