package com.example.mealrecipeexamplepraveen.presentation.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Test
    fun recipeOfTheDayIsDisplayed() {
        launchFragmentInContainer<HomeFragment>()
    }
}