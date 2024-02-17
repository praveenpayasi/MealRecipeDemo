package com.example.mealrecipeexamplepraveen.presentation.home

import com.example.mealrecipeexamplepraveen.domain.categories.CategoriesUseCase
import com.example.mealrecipeexamplepraveen.domain.model.Category
import com.example.mealrecipeexamplepraveen.domain.model.Meal
import com.example.mealrecipeexamplepraveen.domain.recipeOfTheDay.RecipeOfTheDayUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @MockK
    private lateinit var recipeOfTheDayUseCase: RecipeOfTheDayUseCase

    @MockK
    private lateinit var categoriesUseCase: CategoriesUseCase

    @MockK
    private lateinit var recipeOfTheDay: Meal

    @MockK
    private lateinit var category: Category

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainThreadSurrogate)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }


    @Test
    fun `recipe of the day state flow is emitting data`(): Unit = runBlocking {
        launch(Dispatchers.Main) {
            // Step 1 In set up
            val categoriesList = listOf(category)
            coEvery { recipeOfTheDayUseCase.invoke() } returns flowOf(recipeOfTheDay)
            coEvery { categoriesUseCase.invoke() } returns flowOf(categoriesList)

            // Step 2
            viewModel = HomeViewModel(recipeOfTheDayUseCase, categoriesUseCase)
            val recipeOfTheDayStates = viewModel.recipeOfTheDayState.take(2).toList()

            // Step 3
            assertEquals(recipeOfTheDayStates[0], Meal())
            assertEquals(recipeOfTheDayStates[1], recipeOfTheDay)

           val categoriesStates = viewModel.categories.take(2).toList()

            // Step 3
            assertEquals(categoriesStates[0], emptyList<Category>())
            assertEquals(categoriesStates[1], categoriesList)
        }
    }
}