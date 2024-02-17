package com.example.mealrecipeexamplepraveen

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.mealrecipeexamplepraveen.domain.model.Meal
import com.example.mealrecipeexamplepraveen.presentation.area.AreaList
import com.example.mealrecipeexamplepraveen.presentation.area.AreaViewModel
import com.example.mealrecipeexamplepraveen.presentation.home.HomeViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AreaListTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @MockK
    private lateinit var viewModel: AreaViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun recipeOfTheDayIsDisplayed() {
        every { viewModel.areaState } returns MutableStateFlow(
            listOf(
                "Area 1",
                "Area 2",
                "Area 3",
                "Area 4",
                "Area 5",
                "Area 6"
            )
        )

        composeTestRule.setContent {
            AreaList(viewModel)
        }
    }
}