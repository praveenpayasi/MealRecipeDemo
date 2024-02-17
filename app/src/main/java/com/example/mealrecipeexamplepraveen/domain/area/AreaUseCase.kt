package com.example.mealrecipeexamplepraveen.domain.area

import com.example.mealrecipeexamplepraveen.data.area.AreaRepository
import com.example.mealrecipeexamplepraveen.data.categories.CategoryRepository
import com.example.mealrecipeexamplepraveen.domain.model.Category
import kotlinx.coroutines.flow.map

class AreaUseCase(private val repository: AreaRepository) {
    suspend operator fun invoke() = repository.fetchAreas().map { areas ->
        areas.map {
            it.strArea
        }
    }
}