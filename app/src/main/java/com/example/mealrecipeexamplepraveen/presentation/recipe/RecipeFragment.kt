package com.example.mealrecipeexamplepraveen.presentation.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mealrecipeexamplepraveen.data.receipe.RecipeRepository
import com.example.mealrecipeexamplepraveen.data.recipeService
import com.example.mealrecipeexamplepraveen.domain.model.MealX
import com.example.mealrecipeexamplepraveen.domain.recipe.RecipeUseCase
import com.example.mealrecipeexamplepraveen.presentation.kanitFontFamily
import com.skydoves.landscapist.glide.GlideImage

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeFragment : Fragment() {

    private lateinit var viewModel: RecipeViewModel
    private val args: RecipeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = RecipeViewModel(
            RecipeUseCase(
                RecipeRepository(
                    recipeService
                )
            )
        )

        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Column {
                    RecipeList(args.categoryname)
                }
            }
        }
    }

    @Composable
    fun RecipeList(categoryname: String?) {
        categoryname?.let {
            viewModel.getRecipeByCategory(categoryName = categoryname)
            val areas by viewModel.recipeListState.collectAsState()
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                areas.forEach {
                    RecipeListItem(it)
                }
            }
        }
    }

    @Composable
    fun RecipeListItem(meal: MealX) {
        Card(elevation = 10.dp, modifier = Modifier.padding(10.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        val direction =
                            RecipeFragmentDirections.actionRecipeFragmentToRecipeDetailFragment(meal.idMeal)
                        findNavController().navigate(direction)
                    }
            ) {
                GlideImage(
                    imageModel = meal.strMealThumb,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    contentScale = ContentScale.Fit,
                    contentDescription = "Meal image",
                )
                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .height(50.dp)
                        .background(Color.Green)
                )
                Text(
                    text = meal.strMeal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .padding(16.dp),
                    fontWeight = FontWeight.Bold,
                    fontFamily = kanitFontFamily
                )
            }
        }
    }
}