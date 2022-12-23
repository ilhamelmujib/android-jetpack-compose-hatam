package org.hatam.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import org.hatam.android.ui.screen.home.HomeScreen
import org.hatam.android.ui.theme.AllNewHatamTheme

@Composable
fun AllNewHatamApp() {
    HomeScreen()
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun AllNewHatamAppPreview() {
    AllNewHatamTheme {
        HomeScreen()
    }
}