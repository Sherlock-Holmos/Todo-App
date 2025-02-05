package com.holmes.list.feature.week.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun WeekListContainer() {
    val horizontalScrollState = rememberScrollState()
    val verticalScrollState = rememberScrollState()

    Row {
        DayHourColumn(verticalScrollState)
        Column(modifier = Modifier.horizontalScroll(horizontalScrollState)) {
            WeekDaysRow()
            Column(modifier = Modifier.verticalScroll(verticalScrollState)) {
                for (i in 1..20) {
                    Row {
                        for (j in 1..10) {
                            Box(modifier = Modifier.size(60.dp)) {
                                Text("Cell $i,$j")
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun DayHourColumn(verticalScrollState: ScrollState) {
    val hourOfDay = (0..23).toList()
    Column(modifier = Modifier.verticalScroll(verticalScrollState)) {
        Box(modifier = Modifier.size(50.dp)) {}
        for (hour in hourOfDay) {
            Box(modifier = Modifier.size(50.dp)) {
                Text("$hour", color = Color.Gray)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekDaysRow() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val today = LocalDate.now()
    val days = remember { generateInfiniteDays(today) }
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = 500000)

    LaunchedEffect(Unit) {
        listState.scrollToItem(500000 - 2)
    }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyRow(
            state = listState,
            modifier = Modifier
                .width(7 * screenWidth / 8)
                .padding(0.dp)
                .align(Alignment.CenterEnd),
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            itemsIndexed(days) { index, day ->
                val isToday = day == today
                Column(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .padding(vertical = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = day.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH),
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                    Box(
                        modifier = Modifier
                            .size(40.dp) // Set the size to ensure a perfect circle
                            .clip(CircleShape)
                            .background(if (isToday) Color.Blue else Color.Transparent),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${day.dayOfMonth}",
                            fontSize = 16.sp,
                            color = if (isToday) Color.White else Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun generateInfiniteDays(startDate: LocalDate): List<LocalDate> {
    return List(1000000) { startDate.plusDays(it.toLong() - 500000) }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun WeekListContainerPreview() {
    WeekListContainer()
}