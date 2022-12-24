package org.hatam.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.hatam.android.R
import org.hatam.android.ui.theme.AllNewHatamTheme

@Composable
fun TopBarHome(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { },
        elevation = 10.dp,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Avatar()
                Greetings()
            }
            Image(
                painter = painterResource(R.drawable.png_logo),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp)
            )
        }
    }
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.jpeg_avatar),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Image(
            painter = painterResource(R.drawable.ic_crown),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .shadow(elevation = 4.dp, shape = CircleShape)
                .size(15.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(2.dp)
        )
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(start = 10.dp)
    ) {
        Text(
            text = "Assalmualaikum",
            fontSize = 13.sp
        )
        Text(
            text = "M Ilham Abdul Mujib",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarHomePreview() {
    AllNewHatamTheme {
        TopBarHome()
    }
}