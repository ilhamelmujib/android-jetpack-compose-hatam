package org.hatam.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.hatam.android.model.Feed
import org.hatam.android.ui.components.TopBarHome
import org.hatam.android.ui.components.TopBarScreen
import org.hatam.android.ui.navigation.Screen
import org.hatam.android.ui.screen.feed.FeedScreen
import org.hatam.android.ui.screen.home.HomeScreen
import org.hatam.android.ui.screen.profile.ProfileScreen

@Composable
fun AllNewHatamApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        topBar = {
            when (currentRoute) {
                Screen.Home.route -> TopBarHome(
                    navigateToProfile = {
                        navController.navigate(Screen.Profile.route)
                    }
                )
                Screen.Profile.route -> TopBarScreen("Profil", navController)
                else -> TopBarScreen("Postingan", navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToFeed = {
                        navController.navigate(Screen.Feed.createRoute(it))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.Feed.route,
                arguments = listOf(navArgument("feedId"){ type = NavType.LongType})
            ) {
                val id = it.arguments?.getLong("feedId") ?: -1L
                FeedScreen(id)
            }
        }
    }

}
