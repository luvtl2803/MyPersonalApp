package com.an.samplearch.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.an.samplearch.core.model.Task

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onNewTaskClick: () -> Unit
) {
    val tasks by homeViewModel.tasks.collectAsStateWithLifecycle()
    HomeScreen(
        onNewTaskClick = onNewTaskClick,
        tasks = tasks
    )
}

@Composable
fun HomeScreen(
    onNewTaskClick: () -> Unit,
    tasks: List<Task>
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp)
            ) {
                items(tasks) { item ->
                    Text(text = "Task: ${item.title}", fontSize = 20.sp)
                    Spacer(Modifier.height(20.dp))
                    Text(text = "Description: ${item.content}", fontSize = 20.sp)
                    Spacer(Modifier.height(20.dp))
                }
            }
            Spacer(Modifier.height(20.dp))
            Button(
                modifier = Modifier,
                onClick = onNewTaskClick
            ) {
                Text(
                    text = "Create New Task"
                )
            }
        }

    }
}



