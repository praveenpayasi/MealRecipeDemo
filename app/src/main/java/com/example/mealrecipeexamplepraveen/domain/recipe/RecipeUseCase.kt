package com.example.mealrecipeexamplepraveen.domain.recipe

import com.example.mealrecipeexamplepraveen.data.receipe.RecipeRepository
import com.example.mealrecipeexamplepraveen.domain.model.Meal
import com.example.mealrecipeexamplepraveen.domain.model.MealX
import kotlinx.coroutines.flow.map

class RecipeUseCase(private val repository: RecipeRepository) {
    suspend fun fetchRecipeByCategory(categoryName: String) =
        repository.fetchRecipeByCategory(categoryName = categoryName).map { meals ->
            meals.map { mealx ->
                MealX(
                    idMeal = mealx.idMeal,
                    strMeal = mealx.strMeal,
                    strMealThumb = mealx.strMealThumb
                )
            }
        }

    suspend fun fetchRecipeById(mealId: String) =
        repository.fetchRecipeById(mealId = mealId).map { meals ->
            meals.map { mealDetail ->
                Meal(
                    idMeal = mealDetail.idMeal,
                    strArea = mealDetail.strArea,
                    strCategory = mealDetail.strCategory,
                    strIngredient1 = mealDetail.strIngredient1,
                    strIngredient10 = mealDetail.strIngredient10,
                    strIngredient11 = mealDetail.strIngredient11,
                    strIngredient12 = mealDetail.strIngredient12,
                    strIngredient13 = mealDetail.strIngredient13,
                    strIngredient14 = mealDetail.strIngredient14,
                    strIngredient15 = mealDetail.strIngredient15,
                    strIngredient16 = mealDetail.strIngredient16,
                    strIngredient17 = mealDetail.strIngredient17,
                    strIngredient18 = mealDetail.strIngredient18,
                    strIngredient19 = mealDetail.strIngredient19,
                    strIngredient2 = mealDetail.strIngredient2,
                    strIngredient20 = mealDetail.strIngredient20,
                    strIngredient3 = mealDetail.strIngredient3,
                    strIngredient4 = mealDetail.strIngredient4,
                    strIngredient5 = mealDetail.strIngredient5,
                    strIngredient6 = mealDetail.strIngredient6,
                    strIngredient7 = mealDetail.strIngredient7,
                    strIngredient8 = mealDetail.strIngredient8,
                    strIngredient9 = mealDetail.strIngredient9,
                    strInstructions = mealDetail.strInstructions,
                    strMeal = mealDetail.strMeal,
                    strMealThumb = mealDetail.strMealThumb,
                    strMeasure1 = mealDetail.strMeasure1,
                    strMeasure10 = mealDetail.strMeasure10,
                    strMeasure11 = mealDetail.strMeasure11,
                    strMeasure12 = mealDetail.strMeasure12,
                    strMeasure13 = mealDetail.strMeasure13,
                    strMeasure14 = mealDetail.strMeasure14,
                    strMeasure15 = mealDetail.strMeasure15,
                    strMeasure16 = mealDetail.strMeasure16,
                    strMeasure17 = mealDetail.strMeasure17,
                    strMeasure18 = mealDetail.strMeasure18,
                    strMeasure19 = mealDetail.strMeasure19,
                    strMeasure2 = mealDetail.strMeasure2,
                    strMeasure20 = mealDetail.strMeasure20,
                    strMeasure3 = mealDetail.strMeasure3,
                    strMeasure4 = mealDetail.strMeasure4,
                    strMeasure5 = mealDetail.strMeasure5,
                    strMeasure6 = mealDetail.strMeasure6,
                    strMeasure7 = mealDetail.strMeasure7,
                    strMeasure8 = mealDetail.strMeasure8,
                    strMeasure9 = mealDetail.strMeasure9,
                    strTags = mealDetail.strTags,
                    strYoutube = mealDetail.strYoutube
                )
            }.first()
        }
}