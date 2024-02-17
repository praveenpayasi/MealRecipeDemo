package com.example.mealrecipeexamplepraveen.hilt

import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.CategoryService
import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.RecipeOfTheDayService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideRecipeOfTheDayService(retrofit: Retrofit): RecipeOfTheDayService {
        return retrofit.create(RecipeOfTheDayService::class.java)
    }

    @Provides
    fun provideCategoryService(retrofit: Retrofit): CategoryService {
        return retrofit.create(CategoryService::class.java)
    }
}