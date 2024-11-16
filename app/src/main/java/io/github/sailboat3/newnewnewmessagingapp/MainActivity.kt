package io.github.sailboat3.newnewnewmessagingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.NewNewNewMessagingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewNewNewMessagingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationStack(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

var loginPageState = false

@Composable
fun NavigationStack(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Splash") {
        composable("Splash") { Splash(navController) }
        composable("WelcomePage") { WelcomePage(navController) }
        composable("LoginPage") { LoginPage(navController, loginPageState) }
        composable("MainPage") { MainPage(navController) }
    }
}