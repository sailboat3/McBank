package io.github.sailboat3.newnewnewmessagingapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.sailboat3.newnewnewmessagingapp.composables.McButton
import io.github.sailboat3.newnewnewmessagingapp.composables.TertiaryMcButton

@Composable
fun WelcomePage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mcdonalds_logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.size(12.dp))
            Text(
                text = "Welcome to the Bank of the Future",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(text = "Already have an account?")
            Spacer(Modifier.size(12.dp))
            McButton(
                onClick = {
                    navController.navigate("LoginPage") {
                        popUpTo("WelcomePage") { inclusive = true }
                    }
                }
            ) {
                Text(text = "Sign In")
            }

            Spacer(Modifier.size(32.dp))
            val context = LocalContext.current
            Text(text = "Need an account?")
            Spacer(Modifier.size(16.dp))
            TertiaryMcButton(
                onClick = {
                    loginPageState = true
                    navController.navigate("LoginPage") {
                        popUpTo("WelcomePage") { inclusive = true }
                    }
                },
            ) {
                Text(text = "Create Account")
            }
        }
    }
}
