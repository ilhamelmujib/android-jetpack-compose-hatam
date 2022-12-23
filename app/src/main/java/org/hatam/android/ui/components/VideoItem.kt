package org.hatam.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.hatam.android.R
import org.hatam.android.ui.theme.AllNewHatamTheme

@Composable
fun VideoItem(
    photoUrl: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable {
            }
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = photoUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .height(135.dp)
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
            text = "Ustadz Latif",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Cara menggunakan aplikasi Hatam",
            fontSize = 14.sp,
        )

    }
}

@Preview
@Composable
fun VideoItemPreview() {
    AllNewHatamTheme {
        VideoItem("2Bi06euAYlw")
    }
}