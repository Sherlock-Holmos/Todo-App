package com.holmes.list.feature.week.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WeekListContainer() {
    val dayOfWeek = listOf("", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val hourOfDay = (0..23).toList()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            dayOfWeek.forEach { day ->
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(5.dp)
                ) {
                    Text(text = day, color = Color.Gray)
                }
            }
        }
    }
    LazyColumn() {}
}

@Preview
@Composable
fun WeekListContainerPreview() {
    WeekListContainer()
}