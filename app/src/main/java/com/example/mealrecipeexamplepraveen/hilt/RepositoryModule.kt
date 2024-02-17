package com.example.mealrecipeexamplepraveen.hilt

import com.example.mealrecipeexamplepraveen.data.categories.CategoryRepository
import com.example.mealrecipeexamplepraveen.data.categoryService
import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.RecipeOfTheDayRepository
import com.example.mealrecipeexamplepraveen.data.recipeOfTheDayService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class RepositoryModule {
    @Provides
    fun provideRecipeOfTheDayRepository(): RecipeOfTheDayRepository {
        return RecipeOfTheDayRepository(
            recipeOfTheDayService
        )
    }

    @Provides
    fun provideCategoryRepository(): CategoryRepository {
        return CategoryRepository(categoryService)
    }
}