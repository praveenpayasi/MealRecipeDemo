package com.example.mealrecipeexamplepraveen.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mealrecipeexamplepraveen.R

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                TopAppBar(
                    title = {

                    },
                    navigationIcon = {
                        IconButton(onClick = { onBackPressed() }) {
                            Icon(
                                painter = painterResource(id = android.R.drawable.ic_input_add),
                                contentDescription = "Back button"
                            )
                        }
                    },
                    backgroundColor = Color.White,
                    elevation = 0.dp,
                    actions = {
                        IconButton(onClick = { onBackPressed() }) {
                            Icon(
                                painter = painterResource(id = android.R.drawable.ic_menu_share),
                                contentDescription = "Share button"
                            )
                        }
                    }
                )
                Container()
            }
        }
    }

    @Preview
    @Composable
    fun Container() {
        val items = listOf("ABC", "XYZ", "PQR", "LMN")
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Title()
                Text(
                    text = "* Dispatch to", textAlign = TextAlign.Start, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, bottom = 16.dp)
                )
                DropdownSelector(items)
                Text(text = "*Search by Warehouse name/ID")
            }
            ProceedButton()
        }
    }

    @Composable
    fun Title() {
        Text(
            text = "Coconut\nDispatch",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = kanitFontFamily
        )
    }

    @Composable
    fun DropdownSelector(items: List<String>) {
        var expanded by remember { mutableStateOf(false) }
        var selectedText by remember { mutableStateOf("Tap here") }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = selectedText,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black)
                    .padding(16.dp)
                    .clickable(onClick = { expanded = true })
            )
            DropdownMenu(modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Color.LightGray),
                expanded = expanded,
                onDismissRequest = {

                }) {
                items.forEachIndexed { index, item ->
                    DropdownMenuItem(modifier = Modifier
                        .fillMaxWidth(),
                        onClick = {
                            expanded = false
                            selectedText = item
                        }) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = item
                            )
                            if (index != items.lastIndex) {
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .border(
                                            width = 1.dp,
                                            color = Color.LightGray
                                        )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ProceedButton() {
        Button(
            modifier = Modifier.padding(bottom = 48.dp),
            onClick = {
                onBackPressed()
            }
        ) {
            Text("Proceed")
        }
    }
}

val kanitFontFamily = FontFamily(
    Font(R.font.kanitregular, FontWeight.Normal),
    Font(R.font.kanitbold, FontWeight.Bold),
    Font(R.font.kanititalic, FontWeight.Normal, FontStyle.Italic)
)