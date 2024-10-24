package com.an.samplearch.feature.newtask.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.an.samplearch.feature.newtask.NewTaskRoute
import kotlinx.serialization.Serializable

fun NavController.navigationToNewTask() {
    navigate(
        route = NewTaskRoute
    )
}

fun NavGraphBuilder.newTaskScreen(
    onBackHomeClick: () -> Unit,
) {
    composable<NewTaskRoute> {
        NewTaskRoute(onBackHomeClick = onBackHomeClick)
    }
}

@Serializable
data object NewTaskRoute