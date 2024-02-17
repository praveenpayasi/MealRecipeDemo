package com.example.mealrecipeexamplepraveen.data

import com.example.mealrecipeexamplepraveen.data.area.AreaService
import com.example.mealrecipeexamplepraveen.data.receipe.RecipeService
import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.CategoryService
import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.RecipeOfTheDayService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_PATH = "/api/json/"
const val API_VERSION = "v1"
const val ACCESS_TOKEN = "1"

val logging = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
val client = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeOfTheDayService = retrofit.create(RecipeOfTheDayService::class.java)
val categoryService = retrofit.create(CategoryService::class.java)
val areaService = retrofit.create(AreaService::class.java)
val recipeService = retrofit.create(RecipeService::class.java)