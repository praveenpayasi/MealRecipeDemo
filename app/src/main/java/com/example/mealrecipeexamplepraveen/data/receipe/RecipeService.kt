package com.example.mealrecipeexamplepraveen.data.receipe

import com.example.mealrecipeexamplepraveen.data.ACCESS_TOKEN
import com.example.mealrecipeexamplepraveen.data.API_PATH
import com.example.mealrecipeexamplepraveen.data.API_VERSION
import com.example.mealrecipeexamplepraveen.data.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {
    @GET("$API_PATH$API_VERSION/$ACCESS_TOKEN/filter.php")
    suspend fun fetchRecipeByCategory(@Query("c") categoryName: String): RecipeResponse

    @GET("$API_PATH$API_VERSION/$ACCESS_TOKEN/lookup.php")
    suspend fun fetchRecipeById(@Query("i") mealId: String): RecipeDetailResponse
}
