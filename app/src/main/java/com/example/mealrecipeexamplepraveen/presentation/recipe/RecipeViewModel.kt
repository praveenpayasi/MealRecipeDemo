package com.example.mealrecipeexamplepraveen.presentation.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealrecipeexamplepraveen.domain.model.MealX
import com.example.mealrecipeexamplepraveen.domain.recipe.RecipeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val recipeUseCase: RecipeUseCase
) : ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _recipeListState = MutableStateFlow(emptyList<MealX>())

    // The UI collects from this StateFlow to get its state updates
    val recipeListState: StateFlow<List<MealX>> = _recipeListState


    fun getRecipeByCategory(categoryName: String) {
        viewModelScope.launch {
            recipeUseCase.fetchRecipeByCategory(categoryName).collect {
                _recipeListState.value = it
            }
        }
    }
}