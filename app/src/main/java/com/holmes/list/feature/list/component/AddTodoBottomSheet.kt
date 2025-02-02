package com.holmes.list.feature.list.component

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.holmes.list.component.DatePickerModal
import com.holmes.list.data.model.TodoItem
import com.holmes.list.feature.list.ListViewModel
import com.holmes.list.util.SuperDateUtil.timestampToLocalDate
import kotlinx.coroutines.launch
import java.time.LocalDate

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
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    var showModal by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    //显示底部弹窗
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            modifier = Modifier
                .wrapContentHeight()
                .imePadding()
        ) {
            //弹窗内容
            Box {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .imePadding(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Add Todo",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    // 待办标题输入框
                    OutlinedTextField(
                        value = newTodoTitle,
                        onValueChange = { newTodoTitle = it },
                        label = { Text("Title") },
                        trailingIcon = {
                            Icon(Icons.Default.Edit, contentDescription = "Title")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .imePadding(),
                    )
                    // 待办描述输入框
                    OutlinedTextField(
                        value = newTodoDescription,
                        onValueChange = { newTodoDescription = it },
                        label = { Text("Description") },
                        trailingIcon = {
                            Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Description")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .imePadding(),
                    )

                    // 待办日期输入框
                    OutlinedTextField(value = selectedDate?.toString() ?: "",
                        onValueChange = { },
                        label = { Text("Deadline") },
                        placeholder = { Text("MM/DD/YYYY") },
                        trailingIcon = {
                            Icon(Icons.Default.DateRange, contentDescription = "Deadline")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .imePadding()
                            .pointerInput(selectedDate) {
                                awaitEachGesture {
                                    awaitFirstDown(pass = PointerEventPass.Initial)
                                    val upEvent =
                                        waitForUpOrCancellation(pass = PointerEventPass.Initial)
                                    if (upEvent != null) {
                                        showModal = true
                                    }
                                }
                            })

                    if (showModal) {
                        DatePickerModal(
                            onDateSelected = { selectedDate = timestampToLocalDate(it) },
                            onDismiss = { showModal = false }
                        )
                    }

                    // 按钮区域
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
                                    title = newTodoTitle, description = newTodoDescription, date = selectedDate
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
