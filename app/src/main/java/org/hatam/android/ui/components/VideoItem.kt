package org.hatam.android.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import org.hatam.android.R
import org.hatam.android.model.Video
import org.hatam.android.ui.theme.AllNewHatamTheme
import org.hatam.android.utils.getThumbnailYoutube
import org.hatam.android.utils.notNull

@Composable
fun VideoItem(
    video: Video,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    Column(
        modifier = modifier
            .width(300.dp)
            .clickable {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=${video.code}")
                    )
                )
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {
            AsyncImage(
                model = video.code.getThumbnailYoutube(),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
            )

            Image(
                painter = painterResource(R.drawable.ic_play_video),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = video.title.notNull(),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = video.description.notNull(),
            color = Color.Gray,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }
}

@Preview
@Composable
fun VideoItemPreview() {
    AllNewHatamTheme {
        VideoItem(Video())
    }
}