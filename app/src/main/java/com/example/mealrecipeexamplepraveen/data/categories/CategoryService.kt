package com.example.mealrecipeexamplepraveen.data.recipeOfTheDay

import com.example.mealrecipeexamplepraveen.data.ACCESS_TOKEN
import com.example.mealrecipeexamplepraveen.data.API_PATH
import com.example.mealrecipeexamplepraveen.data.API_VERSION
import com.example.mealrecipeexamplepraveen.data.model.CategoriesResponse
import com.example.mealrecipeexamplepraveen.data.model.RecipeOfTheDayResponse
import retrofit2.http.GET

interface CategoryService {
    @GET("$API_PATH$API_VERSION/$ACCESS_TOKEN/categories.php")
    suspend fun fetchCategories(): CategoriesResponse
}