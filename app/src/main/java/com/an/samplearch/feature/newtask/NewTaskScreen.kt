package com.an.samplearch.feature.newtask

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun NewTaskRoute(
    newTaskViewModel: NewTaskViewModel = hiltViewModel(),
    onBackHomeClick: () -> Unit,
) {
    val title by newTaskViewModel.title.collectAsStateWithLifecycle()
    val content: String by newTaskViewModel.content.collectAsStateWithLifecycle()
    NewTaskScreen(
        onBackHomeClick = onBackHomeClick,
        onSaveTaskClick = {
            newTaskViewModel.save()
        },
        title = title,
        onTitleChange = {
            newTaskViewModel.onTitleChange(it)
        },
        content = content,
        onContentChange = {
            newTaskViewModel.onContentChange(it)
        }

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskScreen(
    onBackHomeClick: () -> Unit,
    onSaveTaskClick: () -> Unit,
    title: String,
    onTitleChange: (String) -> Unit,
    content: String,
    onContentChange: (String) -> Unit

) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ), title = {
            Text(text = "")
        }, navigationIcon = {
            IconButton(onClick = onBackHomeClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back to home"
                )
            }
        }, actions = {
            IconButton(onClick = onSaveTaskClick) {
                Icon(
                    imageVector = Icons.Filled.Done, contentDescription = "Save"
                )

            }
        })
        Column(
            modifier = Modifier
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            TextField(
                value = title,
                label = { Text(text = "Task: ") },
                onValueChange = { newText ->
                    onTitleChange(newText)
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                value = content,
                label = { Text(text = "Description: ") },
                onValueChange = { newText ->
                    onContentChange(newText)
                }
            )
        }

    }
}

@Preview
@Composable
private fun NewTaskScreenPreview() {
    NewTaskScreen(
        onBackHomeClick = {},
        onSaveTaskClick = {},
        title = "",
        onTitleChange = {},
        content = "",
        onContentChange = {}
    )
}
