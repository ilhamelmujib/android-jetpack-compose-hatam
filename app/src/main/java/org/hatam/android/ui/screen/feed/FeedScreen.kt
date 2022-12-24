package org.hatam.android.ui.screen.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import org.hatam.android.R
import org.hatam.android.model.Feed
import org.hatam.android.ui.common.UiState
import org.hatam.android.ui.theme.AllNewHatamTheme
import org.hatam.android.utils.notNull

@Composable
fun FeedScreen(
    feedId: Long,
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel = viewModel(
        factory = FeedViewModel.provideFactory()
    ),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getFeeds()
            }
            is UiState.Success -> {
                FeedDetail(feedId, uiState.data, modifier)
            }
            is UiState.Error -> {}
        }
    }

}

@Composable
fun FeedDetail(
    feedId: Long,
    feeds: List<Feed>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier)
    {
        item {
            val feed = feeds.find { it.id.toLong() == feedId } ?: Feed()
            FeedContent(feed)
        }
        item {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(Color.LightGray))
            FeedContentList(feedId, feeds)
        }
    }
}

@Composable
fun FeedContent(
    feed: Feed,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = feed.photo,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
        BottomFeedContent(feed)
    }
}

@Composable
fun BottomFeedContent(
    feed: Feed,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = feed.user?.name.notNull(),
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )
        Text(
            text = feed.caption.notNull(),
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, start = 20.dp, end = 20.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_like),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Image(
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            Text(
                text = feed.totalLikes.notNull(),
                fontSize = 14.sp,
            )
        }

    }
}


@Composable
fun FeedContentList(
    feedId: Long,
    feeds: List<Feed>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Explore",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 15.dp, start = 15.dp)
        )

        val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 3)
        FlowRow(
            modifier = Modifier.padding(15.dp),
            mainAxisSize = SizeMode.Expand,
            mainAxisSpacing = 1.dp,
            crossAxisSpacing = 10.dp,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween
        ) {
            val data = feeds.filterNot { it.id.toLong() == feedId }
            data.forEach {
                AsyncImage(
                    model = it.photo,
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .size(itemSize - 17.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    AllNewHatamTheme {
        FeedContent(Feed())
    }
}
