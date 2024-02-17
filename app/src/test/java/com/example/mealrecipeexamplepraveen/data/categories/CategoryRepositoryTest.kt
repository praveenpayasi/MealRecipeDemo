package com.example.mealrecipeexamplepraveen.data.categories

import com.example.mealrecipeexamplepraveen.data.model.CategoriesResponse
import com.example.mealrecipeexamplepraveen.data.model.Category
import com.example.mealrecipeexamplepraveen.data.recipeOfTheDay.CategoryService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CategoryRepositoryTest{

    @MockK
    private lateinit var categoryService: CategoryService

    @MockK
    private lateinit var categoryList : List<Category>

    @MockK
    private lateinit var categoryResponse: CategoriesResponse

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun fetchCategoriesTest(){

        coEvery { categoryService.fetchCategories() } returns categoryResponse
        coEvery { categoryResponse.categories }  returns categoryList

        val categoryRepository  =  CategoryRepository(categoryService)
        runBlocking {
            val actualResponse = categoryRepository.fetchCategories().first()
            val expectedResponse = categoryList
            assertEquals(expectedResponse,actualResponse)
        }

    }
}