package com.example.mealrecipeexamplepraveen.presentation.area

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AreaList(viewModel: AreaViewModel) {
    val areas by viewModel.areaState.collectAsState()
    Column {
        areas.forEach {
            AreaListItem(it)
        }
    }
}

@Composable
fun AreaListItem(areaName: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.border(1.dp, Color.Green)
    ) {
        Text(
            text = areaName,
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(16.dp)
        )
    }
}