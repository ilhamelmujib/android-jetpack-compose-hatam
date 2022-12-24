package org.hatam.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.hatam.android.R
import org.hatam.android.ui.theme.AllNewHatamTheme

@Composable
fun TopBarScreen(
    title: String,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = 10.dp,
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.align(Alignment.CenterStart),
                elevation = null,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                onClick = {
                    navController.navigateUp()
                }) {
                Image(
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                )
            }

            Text(
                modifier = Modifier.align(Alignment.Center),
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarScreenPreview() {
    AllNewHatamTheme {
        TopBarScreen("Profil", rememberNavController())
    }
}