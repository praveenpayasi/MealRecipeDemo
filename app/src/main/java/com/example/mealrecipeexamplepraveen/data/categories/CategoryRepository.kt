package com.example.mealrecipeexamplepraveen.data.categories

import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.CategoryService
import kotlinx.coroutines.flow.flow

class CategoryRepository(private val service: CategoryService) {
    suspend fun fetchCategories() = flow {
        emit(service.fetchCategories().categories)
    }
}