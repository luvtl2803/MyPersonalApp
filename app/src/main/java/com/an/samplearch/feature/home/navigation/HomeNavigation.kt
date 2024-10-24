package com.an.samplearch.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.an.samplearch.feature.home.HomeRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToHome() {
    navigate(
        route = HomeRoute
    )
}

fun NavGraphBuilder.homeScreen(
    onNewTaskClick: () -> Unit
) {
    composable<HomeRoute> {
        HomeRoute(
            onNewTaskClick = onNewTaskClick
        )
    }
}

@Serializable
data object HomeRoute