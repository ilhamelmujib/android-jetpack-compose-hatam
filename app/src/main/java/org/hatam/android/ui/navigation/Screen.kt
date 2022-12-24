package org.hatam.android.ui.navigation

import  org.hatam.android.model.Feed

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Profile: Screen("profile")
    object Feed: Screen("feed/{feedId}"){
        fun createRoute(feedId: Long) = "feed/$feedId"
    }
}