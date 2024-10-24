package com.an.samplearch.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.an.samplearch.feature.home.navigation.HomeRoute
import com.an.samplearch.feature.home.navigation.homeScreen
import com.an.samplearch.feature.newtask.navigation.navigationToNewTask
import com.an.samplearch.feature.newtask.navigation.newTaskScreen

@Composable
fun MtNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        homeScreen(
            onNewTaskClick = {
                navController.navigationToNewTask()
            }
        )
        newTaskScreen(
            onBackHomeClick = {
                navController.popBackStack()
            },
        )
    }
}