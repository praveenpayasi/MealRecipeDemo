package com.example.mealrecipeexamplepraveen.domain.categories

import com.example.mealrecipeexamplepraveen.data.categories.CategoryRepository
import com.example.mealrecipeexamplepraveen.domain.model.Category
import kotlinx.coroutines.flow.map

class CategoriesUseCase(private val repository: CategoryRepository) {
    suspend operator fun invoke() = repository.fetchCategories().map { listOfCategories ->
        listOfCategories.map { category ->
            Category(
                idCategory = category.idCategory,
                strCategory = category.strCategory,
                strCategoryDescription = category.strCategoryDescription,
                strCategoryThumb = category.strCategoryThumb
            )
        }
    }
}