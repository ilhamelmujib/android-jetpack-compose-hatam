package org.hatam.android.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.hatam.android.ui.theme.AllNewHatamTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.hatam.android.R

@Composable
fun ShariaPoint(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(10.dp)
        ) {
            PrayTimes()
            Row {
                ShariaButton("Masjid", R.drawable.ic_mosque)
                ShariaButton("Kiblat", R.drawable.ic_qibla)
            }
        }
    }
}

@Composable
fun PrayTimes() {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "Shubuh -(07:00:00)",
            fontSize = 15.sp,
        )
        Text(
            text = "04:02",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Lihat jadwal shalat >",
            fontSize = 14.sp,
        )
    }
}

@Composable
fun ShariaButton(
    title: String,
    @DrawableRes icon: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(6.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier
                    .shadow(elevation = 4.dp, shape = CircleShape)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(8.dp)
            )
        }
        Text(
            text = title,
            fontSize = 15.sp,
            modifier = Modifier.padding(3.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrayerTimesPreview() {
    AllNewHatamTheme {
        ShariaPoint()
    }
}