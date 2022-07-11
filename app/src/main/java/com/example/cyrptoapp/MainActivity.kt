package com.example.cyrptoapp


import android.graphics.fonts.FontStyle
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.cyrptoapp.ui.theme.CyrptoAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CyrptoAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "listScreen") {
                    composable("listScreen") {
                        MainActivity()
                    }
                    composable(
                        "detailScreen/{currency}/{price}",
                        arguments = listOf(navArgument("currency") {
                            type = NavType.StringType
                        }, navArgument("price") {
                            type = NavType.StringType
                        })
                    ) {

                    }
                }

                MainScreen(navController)
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(topBar = { TopBar() }) {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {

        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(backgroundColor = Color(0xFF5f5fc4)) {
        Text(text = "My Compose App", color = Color.White, fontFamily = FontFamily.Monospace)
        Icon(
            Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier
                .padding(start = 220.dp)
                .size(25.dp)
        )
    }
}

@Composable
fun getTextField(string: String, function: (String) -> Unit) {
    TextField(value = string, onValueChange = function)
}

