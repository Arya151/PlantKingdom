package com.kingdom.plant.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingdom.plant.domain.repository.PlantRepository
import com.kingdom.plant.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantListViewModel @Inject constructor(val repository: PlantRepository) : ViewModel() {

    var state by mutableStateOf(PlantListState())

    init {
        loadPlantList()
    }

    private fun loadPlantList() {
        viewModelScope.launch {
            repository
                .getPlantList()
                .flowOn(Dispatchers.IO)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result?.data?.let {
                                state = state.copy(isLoading = false, plantList = it)
                            }
                        }

                        is Resource.Error -> {

                        }

                        is Resource.Loading -> {
                            state = state.copy(isLoading = true)
                        }
                    }

                }


        }
    }
}