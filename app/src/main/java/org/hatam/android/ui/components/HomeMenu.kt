package org.hatam.android.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.hatam.android.R
import org.hatam.android.ui.theme.AllNewHatamTheme

@Composable
fun HomeMenu(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ) {
        MenuButton(title = "Hafalan", icon = R.drawable.ic_hafalan)
        MenuButton(title = "Setoran", icon = R.drawable.ic_setoran)
        MenuButton(title = "Kelas Ngaji", icon = R.drawable.ic_kelas_ngaji)
        MenuButton(title = "Monitoring", icon = R.drawable.ic_monitoring)
        MenuButton(title = "Tilawah", icon = R.drawable.ic_tilawah)
    }
}

@Composable
fun MenuButton(
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
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(45.dp)
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
fun MenuPreview() {
    AllNewHatamTheme {
        HomeMenu()
    }
}
