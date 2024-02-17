package com.example.mealrecipeexamplepraveen.domain.recipe

import com.example.mealrecipeexamplepraveen.data.receipe.RecipeRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.example.mealrecipeexamplepraveen.data.model.MealX as DataMeal
import com.example.mealrecipeexamplepraveen.domain.model.MealX as DomainMeal

class RecipeUseCaseTest {

    @MockK
    private lateinit var repository: RecipeRepository


    private val listOfDataMealX: List<DataMeal> = listOf(
        DataMeal(idMeal = "1", strMeal = "Recipe 1", strMealThumb = "image url 1"),
        DataMeal(idMeal = "2", strMeal = "Recipe 2", strMealThumb = "image url 2"),
    )

    private val listOfDomainMealX: List<DomainMeal> = listOf(
        DomainMeal(idMeal = "1", strMeal = "Recipe 1", strMealThumb = "image url 1"),
        DomainMeal(idMeal = "2", strMeal = "Recipe 2", strMealThumb = "image url 2"),
    )

    private lateinit var recipeUseCase: RecipeUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        recipeUseCase = RecipeUseCase(repository)
    }

    @Test
    fun `when recipe by category is fetched then it is mapped to MealX`() {
        // Step 1
        coEvery { repository.fetchRecipeByCategory("Vegan") } returns flowOf(listOfDataMealX)
        runBlocking {
            // Step 2
            val actualDomainMealX = recipeUseCase.fetchRecipeByCategory("Vegan").first()

            // Step 3
            assertEquals(listOfDomainMealX, actualDomainMealX)
        }
    }
}