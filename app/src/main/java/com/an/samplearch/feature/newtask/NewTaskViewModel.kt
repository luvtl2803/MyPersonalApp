package com.an.samplearch.feature.newtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.an.samplearch.core.data.repository.TaskRepository
import com.an.samplearch.core.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@HiltViewModel
class NewTaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title
    private val _content = MutableStateFlow("")
    var content: StateFlow<String> = _content

    fun onTitleChange(title: String) {
        _title.value = title
    }

    fun onContentChange(content: String) {
        _content.value = content
    }

    @OptIn(ExperimentalUuidApi::class)
    fun save() {
        viewModelScope.launch {
            val task = Task(
                id = Uuid.random().toString(),
                title = title.value,
                content = content.value
            )
            taskRepository.insertTask(task)
        }

    }
}