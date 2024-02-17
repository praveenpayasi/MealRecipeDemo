package com.example.mealrecipeexamplepraveen.presentation.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mealrecipeexamplepraveen.data.receipe.RecipeRepository
import com.example.mealrecipeexamplepraveen.data.recipeService
import com.example.mealrecipeexamplepraveen.domain.recipe.RecipeUseCase
import com.example.mealrecipeexamplepraveen.presentation.kanitFontFamily
import com.skydoves.landscapist.glide.GlideImage

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 * UI Reference: https://github.com/hardik-trivedi/TheMealRecipeApp
 */
class RecipeDetailFragment : Fragment() {

    private lateinit var viewModel: RecipeDetailViewModel
    private val args: RecipeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = RecipeDetailViewModel(
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
                    RecipeDetail(args.mealId)
                }
            }
        }
    }

    @Composable
    fun RecipeDetail(mealId: String) {
        viewModel.getRecipeById(mealId = mealId)
        val mealDetail by viewModel.recipeDetailState.collectAsState()
        val scrollState = rememberScrollState()

        Column(modifier = Modifier.verticalScroll(scrollState)) {
            GlideImage(
                imageModel = mealDetail.strMealThumb,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Recipe image"
            )
            Text(
                text = mealDetail.strMeal,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = kanitFontFamily, fontSize = 22.sp
            )

            Text(
                text = mealDetail.strCategory,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, bottom = 16.dp),
                fontWeight = FontWeight.Normal,
                fontFamily = kanitFontFamily, fontSize = 18.sp
            )

            Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth().width(1.dp))

            Text(
                text = "Ingredients",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = kanitFontFamily, fontSize = 22.sp
            )

            Row {
                Text(
                    text = mealDetail.strIngredient1,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp,
                )
                Text(
                    text = mealDetail.strIngredient2,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
                Text(
                    text = mealDetail.strIngredient3,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
            }

            Row {
                Text(
                    text = mealDetail.strIngredient4,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp,
                )
                Text(
                    text = mealDetail.strIngredient5,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
                Text(
                    text = mealDetail.strIngredient6,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
            }

            Row {
                Text(
                    text = mealDetail.strIngredient7,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp,
                )
                Text(
                    text = mealDetail.strIngredient8,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
                Text(
                    text = mealDetail.strIngredient9,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp)
                        .background(color = Color.Green, shape = RectangleShape)
                        .padding(6.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
            }

            Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth().width(1.dp))

            Text(
                text = "Steps to cook",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = kanitFontFamily, fontSize = 22.sp
            )

            Row {
                Text(
                    text = mealDetail.strMeasure1,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )

                Text(
                    text = mealDetail.strMeasure2,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )

                Text(
                    text = mealDetail.strMeasure3,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
            }

            Row {
                Text(
                    text = mealDetail.strMeasure4,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )

                Text(
                    text = mealDetail.strMeasure5,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )

                Text(
                    text = mealDetail.strMeasure6,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
            }

            Row {
                Text(
                    text = mealDetail.strMeasure7,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )

                Text(
                    text = mealDetail.strMeasure8,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )

                Text(
                    text = mealDetail.strMeasure9,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = kanitFontFamily, fontSize = 14.sp
                )
            }

            Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth().width(1.dp))

            Text(
                text = "Tags",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = kanitFontFamily, fontSize = 22.sp
            )

            Text(
                text = mealDetail.strTags!!,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 16.dp),
                fontWeight = FontWeight.Normal,
                fontFamily = kanitFontFamily, fontSize = 14.sp
            )
        }


    }
}