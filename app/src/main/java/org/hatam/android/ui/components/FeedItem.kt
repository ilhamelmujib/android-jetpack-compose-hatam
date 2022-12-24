package org.hatam.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.hatam.android.R
import org.hatam.android.model.Feed
import org.hatam.android.ui.theme.AllNewHatamTheme
import org.hatam.android.utils.notNull

@Composable
fun FeedItem(
    feed: Feed,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp, start = 15.dp, end = 15.dp)
            .clickable { onClick() },
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = modifier
        ) {
            TopFeed(feed)
            AsyncImage(
                model = feed.photo,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            BottomFeed(feed)
        }
    }
}

@Composable
fun TopFeed(
    feed: Feed,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(20.dp)) {
        AsyncImage(
            model = feed.user?.photo,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = feed.user?.name.notNull(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(3.dp))
                Image(
                    painter = painterResource(R.drawable.ic_approved),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(18.dp)
                )
            }
            Text(
                text = feed.createdAt.notNull(),
                fontSize = 13.sp,
                color = Color.Gray
            )
        }

    }
}

@Composable
fun BottomFeed(
    feed: Feed,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = feed.caption.notNull(),
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
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

@Preview
@Composable
fun FeedItemPreview() {
    AllNewHatamTheme {
        FeedItem(Feed(), {})
    }
}