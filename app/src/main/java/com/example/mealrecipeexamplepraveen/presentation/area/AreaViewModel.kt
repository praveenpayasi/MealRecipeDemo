package com.example.mealrecipeexamplepraveen.presentation.area

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealrecipeexamplepraveen.domain.area.AreaUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AreaViewModel(
    private val areaUseCase: AreaUseCase
) : ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _areaState = MutableStateFlow(emptyList<String>())

    // The UI collects from this StateFlow to get its state updates
    val areaState: StateFlow<List<String>> = _areaState

    init {
        getAreas()
    }


    private fun getAreas() {
        viewModelScope.launch {
            areaUseCase().collect {
                _areaState.value = it
            }
        }
    }
}