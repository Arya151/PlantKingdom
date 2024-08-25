package com.kingdom.plant.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kingdom.plant.presentation.ui.theme.greenDark
import com.kingdom.plant.presentation.ui.theme.greenLight
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: PlantListViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = greenLight),
    ) {
        Text(
            text = "Plant Kingdom",
            color = greenDark,
            fontWeight = FontWeight.Bold,
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(state.plantList.size) { i ->
                val plant = state.plantList[i]
                PlantListItem(data = plant)
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
            }
        }
    }
}