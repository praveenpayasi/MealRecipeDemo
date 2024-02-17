package com.example.mealrecipeexamplepraveen.data.recipeOfTheDay

import com.example.mealrecipeexamplepraveen.data.model.Meal
import com.example.mealrecipeexamplepraveen.data.model.RecipeOfTheDayResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RecipeOfTheDayRepositoryTest {

    @MockK
    private lateinit var service: RecipeOfTheDayService

    @MockK
    private lateinit var meal1: Meal

    @MockK
    private lateinit var meal2: Meal

    @MockK
    private lateinit var recipeOfTheDayResponse: RecipeOfTheDayResponse

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `recipe of the day is fetched`() {
        //Step 1 Preparation of test data
        coEvery { service.recipeOfTheDay() } returns recipeOfTheDayResponse
        coEvery { recipeOfTheDayResponse.meals } returns listOf(meal1, meal2)

        runBlocking {
            // Step 2 functionality under the test
            val repository = RecipeOfTheDayRepository(service)
            val actualResponse = repository.fetchRecipeOfTheDay().first()

            // Step 3 Assertions. Checking we are getting what we are expecting
            val expectedMeal = meal1
            assertEquals(expectedMeal, actualResponse)
        }
    }
}