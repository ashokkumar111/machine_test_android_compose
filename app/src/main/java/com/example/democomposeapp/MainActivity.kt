package com.example.democomposeapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.democomposeapp.api.PhotoApi
import com.example.democomposeapp.screens.testScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App11()

        }
    }

    @Composable
    fun App11() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "machineTestList") {

            composable(route = "machineTestList") {
                testScreen() {
                    navController.navigate(route = "nextScreen")
                }
            }
            composable(route = "nextScreen") {
                nextScreen()
            }


        }
    }


    @Composable
    private fun nextScreen() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()) {
            Text(
                text = "Wellcome to second Screen", style = TextStyle(
                    Color.Green,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W600
                )
            )
        }
    }
}
