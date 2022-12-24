package org.hatam.android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.hatam.android.model.Feed
import org.hatam.android.ui.theme.AllNewHatamTheme
import org.hatam.android.utils.DummyData
import org.hatam.android.utils.notNull

@Composable
fun FeedColumn(
    feeds: List<Feed>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(feeds, key = { it.id.notNull() }) {
            FeedItem(it, {})
        }
    }
}

@Preview
@Composable
fun FeedColumnPreview() {
    AllNewHatamTheme {
        FeedColumn(feeds = DummyData.feeds)
    }
}

