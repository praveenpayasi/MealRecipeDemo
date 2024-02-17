package com.example.mealrecipeexamplepraveen.data.area

import com.example.mealrecipeexamplepraveen.data.ACCESS_TOKEN
import com.example.mealrecipeexamplepraveen.data.API_PATH
import com.example.mealrecipeexamplepraveen.data.API_VERSION
import com.example.mealrecipeexamplepraveen.data.model.AreaResponse
import com.example.mealrecipeexamplepraveen.data.model.CategoriesResponse
import com.example.mealrecipeexamplepraveen.data.model.RecipeOfTheDayResponse
import retrofit2.http.GET

interface AreaService {
    @GET("$API_PATH$API_VERSION/$ACCESS_TOKEN/list.php?a=list")
    suspend fun fetchAreas(): AreaResponse
}