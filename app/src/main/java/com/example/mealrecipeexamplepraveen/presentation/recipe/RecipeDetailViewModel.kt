package com.example.mealrecipeexamplepraveen.presentation.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealrecipeexamplepraveen.domain.model.Meal
import com.example.mealrecipeexamplepraveen.domain.recipe.RecipeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeDetailViewModel(
    private val recipeUseCase: RecipeUseCase
) : ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _recipeDetailState = MutableStateFlow(Meal())

    // The UI collects from this StateFlow to get its state updates
    val recipeDetailState: StateFlow<Meal> = _recipeDetailState


    fun getRecipeById(mealId: String) {
        viewModelScope.launch {
            recipeUseCase.fetchRecipeById(mealId).collect {
                _recipeDetailState.value = it
            }
        }
    }
}