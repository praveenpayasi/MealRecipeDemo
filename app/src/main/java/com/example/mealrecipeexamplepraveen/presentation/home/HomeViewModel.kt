package com.example.mealrecipeexamplepraveen.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealrecipeexamplepraveen.domain.categories.CategoriesUseCase
import com.example.mealrecipeexamplepraveen.domain.model.Category
import com.example.mealrecipeexamplepraveen.domain.recipeOfTheDay.RecipeOfTheDayUseCase
import com.example.mealrecipeexamplepraveen.domain.model.Meal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val recipeOfTheDayUseCase: RecipeOfTheDayUseCase,
    private val categoriesUseCase: CategoriesUseCase
) :
    ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _recipeOfTheDayState = MutableStateFlow(Meal())

    // The UI collects from this StateFlow to get its state updates
    val recipeOfTheDayState: StateFlow<Meal> = _recipeOfTheDayState

    private val _categories = MutableStateFlow(emptyList<Category>())
    val categories: StateFlow<List<Category>> = _categories

    init {
        getRecipeOfTheDay()
        getCategories()
    }

    private fun getRecipeOfTheDay() {
        viewModelScope.launch {
            recipeOfTheDayUseCase().collect {
                _recipeOfTheDayState.value = it
            }
        }
    }

    private fun getCategories() {
        viewModelScope.launch {
            categoriesUseCase().collect {
                _categories.value = it
            }
        }
    }
}