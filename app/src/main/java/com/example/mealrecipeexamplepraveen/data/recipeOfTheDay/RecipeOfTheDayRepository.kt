package com.example.mealrecipeexamplepraveen.data.recipeOfTheDay

import kotlinx.coroutines.flow.flow

class RecipeOfTheDayRepository(private val service: RecipeOfTheDayService) {
    suspend fun fetchRecipeOfTheDay() = flow {
        emit(service.recipeOfTheDay().meals.first())
    }
}