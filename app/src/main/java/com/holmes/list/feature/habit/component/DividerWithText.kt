package com.holmes.list.feature.habit.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DividerWithText(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = text, style = MaterialTheme.typography.bodyMedium)
        }
        Divider(modifier = Modifier.weight(1f))
    }
}