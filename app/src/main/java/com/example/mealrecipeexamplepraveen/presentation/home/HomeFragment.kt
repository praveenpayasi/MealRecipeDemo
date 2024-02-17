package com.example.mealrecipeexamplepraveen.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.mealrecipeexamplepraveen.domain.model.Category
import com.example.mealrecipeexamplepraveen.presentation.kanitFontFamily
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint

//TODO Add scroll
//TODO Improve styling (Text size, spacing, divider height)

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Column {
                    val viewModel: HomeViewModel = viewModel()
                    RecipeOfTheDay(viewModel)
                    CategoryList(viewModel)
                }
            }
        }
    }

    @Composable
    fun RecipeOfTheDay(viewModel: HomeViewModel) {
        val meal by viewModel.recipeOfTheDayState.collectAsState()
        Column(modifier = Modifier.clickable {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToRecipeDetailFragment(meal.idMeal)
            findNavController().navigate(direction)
        }) {
            GlideImage(
                imageModel = meal.strMealThumb,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Recipe image"
            )
            Text(
                text = meal.strMeal,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, bottom = 16.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = kanitFontFamily, fontSize = 22.sp
            )
        }
    }

    @Composable
    fun CategoryList(viewModel: HomeViewModel) {
        val categories by viewModel.categories.collectAsState()
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            categories.forEach {
                CategoryListItem(it)
            }
        }
    }

    @Composable
    fun CategoryListItem(category: Category) {
        Card(elevation = 10.dp, modifier = Modifier.padding(10.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        val direction =
                            HomeFragmentDirections.actionHomeFragmentToRecipeFragment(category.strCategory)
                        findNavController().navigate(direction)
                    }
            ) {
                GlideImage(
                    imageModel = category.strCategoryThumb,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    contentScale = ContentScale.Fit,
                    contentDescription = "Category image"
                )
                Column() {
                    Text(
                        text = category.strCategory,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 16.dp, start = 16.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = kanitFontFamily
                    )

                    Text(
                        text = category.strCategoryDescription,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                        fontWeight = FontWeight.Normal,
                        fontFamily = kanitFontFamily,
                        maxLines = 3, overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}