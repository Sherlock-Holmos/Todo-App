package com.holmes.list.feature.list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.holmes.list.data.model.TodoItem
import com.holmes.list.data.viewmodel.TodoViewModel
import com.holmes.list.feature.list.ListViewModel
import kotlinx.coroutines.launch

/**
 * 底部弹窗内容，用于添加待办信息
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTodoBottomSheet(
    showBottomSheet: Boolean, onDismiss: () -> Unit, viewModel: ListViewModel
) {
    //待办类信息
    var newTodoTitle by remember { mutableStateOf("") }
    var newTodoDescription by remember { mutableStateOf("") }
    var newTodoDeadline by remember { mutableStateOf("") }

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss, sheetState = sheetState
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Add Todo",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    // 待办标题输入框
                    OutlinedTextField(value = newTodoTitle,
                        onValueChange = { newTodoTitle = it },
                        label = { Text("Title") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    // 待办描述输入框
                    OutlinedTextField(value = newTodoDescription,
                        onValueChange = { newTodoDescription = it },
                        label = { Text("Description") },
                        modifier = Modifier.fillMaxWidth()
                    )


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 添加按钮
                        Button(modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp), onClick = {
                            viewModel.insertTodo(
                                TodoItem(
                                    title = newTodoTitle, description = newTodoDescription
                                )
                            )
                            onDismiss()
                        }) {
                            Text("Add")
                        }

                        // 取消按钮
                        Button(modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp), onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    onDismiss()
                                }
                            }
                        }) {
                            Text("Cancel")
                        }
                    }
                }
            }
        }
    }
}
