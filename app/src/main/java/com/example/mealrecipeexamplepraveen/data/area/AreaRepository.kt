package com.example.mealrecipeexamplepraveen.data.area

import kotlinx.coroutines.flow.flow

class AreaRepository(private val service: AreaService) {
    suspend fun fetchAreas() = flow {
        emit(service.fetchAreas().areas)
    }
}