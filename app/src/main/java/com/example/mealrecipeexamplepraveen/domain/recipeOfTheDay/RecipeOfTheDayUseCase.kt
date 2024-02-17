package com.example.mealrecipeexamplepraveen.domain.recipeOfTheDay

import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.RecipeOfTheDayRepository
import com.example.mealrecipeexamplepraveen.domain.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeOfTheDayUseCase(private val repository: RecipeOfTheDayRepository) {
    suspend operator fun invoke(): Flow<Meal> = repository.fetchRecipeOfTheDay().map {
        Meal(
            idMeal = it.idMeal,
            strMeal = it.strMeal,
            strMealThumb = it.strMealThumb
        )
    }
}