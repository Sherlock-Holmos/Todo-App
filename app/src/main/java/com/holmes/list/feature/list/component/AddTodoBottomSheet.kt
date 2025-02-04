package com.holmes.list.feature.list.component

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.holmes.list.component.TimePickerModel
import com.holmes.list.data.model.TodoItem
import com.holmes.list.feature.list.ListViewModel
import com.holmes.list.util.SuperDateUtil.timestampToLocalDate
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime

/**
 * 底部弹窗内容，用于添加待办信息
 */
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTodoBottomSheet(
    showBottomSheet: Boolean, onDismiss: () -> Unit, viewModel: ListViewModel
) {
    //待办标题
    var newTodoTitle by remember { mutableStateOf("") }
    // 待办描述信息
    var newTodoDescription by remember { mutableStateOf("") }
    // 保存选择的日期
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    // 保存选择的时间
    var selectedTime by remember { mutableStateOf<LocalTime?>(null) }

    var showModal by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    // 控制时间选择器是否显示
    var showTimePicker by remember { mutableStateOf(false) }

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
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 0.dp)
                        .fillMaxWidth()
                        .imePadding(),
                    //verticalArrangement = Arrangement.spacedBy(16.dp)
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

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        // 待办日期点击按钮
                        IconButton(
                            onClick = {
                                showModal = true
                            }, modifier = Modifier.weight(1f)
                        ) {
                            Row {
                                Icon(Icons.Default.DateRange, contentDescription = "Deadline")
                                Text(text = selectedDate?.toString() ?: "")
                            }
                        }
                        // 待办时间点击按钮
                        IconButton(
                            onClick = {
                                showTimePicker = true
                            }, modifier = Modifier.weight(1f)
                        ) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = null
                                )
                                Text(text = selectedTime?.toString() ?: "")
                            }
                        }
                    }

                    if (showModal) {
                        DatePickerModal(onDateSelected = {
                            selectedDate = timestampToLocalDate(it)
                        }, onDismiss = { showModal = false })
                    }

                    // 时间选择器对话框
                    if (showTimePicker) {
                        TimePickerModel(onConfirm = { timePickerState ->
                            // 将选择的时间转换为 LocalTime
                            val time = LocalTime.of(timePickerState.hour, timePickerState.minute)
                            selectedTime = time
                            showTimePicker = false // 关闭时间选择器
                        }, onDismiss = {
                            showTimePicker = false // 关闭时间选择器
                        })
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
                                    title = newTodoTitle,
                                    description = newTodoDescription,
                                    date = selectedDate,
                                    time = selectedTime
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
