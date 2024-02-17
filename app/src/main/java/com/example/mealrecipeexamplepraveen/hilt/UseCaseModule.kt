package com.example.mealrecipeexamplepraveen.hilt

import com.example.mealrecipeexamplepraveen.data.categories.CategoryRepository
import com.example.mealrecipeexamplepraveen.data.categoryService
import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.RecipeOfTheDayRepository
import com.example.mealrecipeexamplepraveen.data.recipeOfTheDayService
import com.example.mealrecipeexamplepraveen.domain.categories.CategoriesUseCase
import com.example.mealrecipeexamplepraveen.domain.recipeOfTheDay.RecipeOfTheDayUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideRecipeOfTheDayUseCase(recipeOfTheDayRepository:RecipeOfTheDayRepository): RecipeOfTheDayUseCase {
        return RecipeOfTheDayUseCase(recipeOfTheDayRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideCategoryUseCase(categoryRepository:CategoryRepository): CategoriesUseCase {
        return CategoriesUseCase(categoryRepository)
    }
}