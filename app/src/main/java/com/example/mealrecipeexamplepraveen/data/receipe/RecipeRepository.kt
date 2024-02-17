package com.example.mealrecipeexamplepraveen.data.receipe

import kotlinx.coroutines.flow.flow

class RecipeRepository(private val service: RecipeService) {
    suspend fun fetchRecipeByCategory(categoryName : String) = flow {
        emit(service.fetchRecipeByCategory(categoryName).meals)
    }

    suspend fun fetchRecipeById(mealId: String) = flow {
        emit(service.fetchRecipeById(mealId).meals)
    }
}