package io.github.sailboat3.newnewnewmessagingapp


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.sailboat3.newnewnewmessagingapp.composables.McButton
import io.github.sailboat3.newnewnewmessagingapp.composables.SecondaryMcButton
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.McDonaldsGreen
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.McDonaldsWhite

var currentBalance: MutableState<Double?> = mutableStateOf(loggedInUser?.balance)

@Composable
fun MainPage(navController: NavController) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        LandscapeLayout(navController)
    } else {
        PortraitLayout(navController)
    }

}

@Composable
fun LandscapeLayout(navController: NavController) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
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
            Spacer(Modifier.size(16.dp))
            Text(
                text = "Welcome, ${loggedInUser?.username}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(Modifier.size(16.dp))
            McButton(
                onClick = {
                    navController.navigate("WelcomePage") {
                        popUpTo("WelcomePage") { inclusive = true }
                    }
                }
            ) {
                Text(text = "Log Out")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$${currentBalance.value}",
                fontWeight = FontWeight.Bold,
                fontSize = 64.sp,
                lineHeight = 64.sp,
                color = if (!isSystemInDarkTheme()) McDonaldsGreen else McDonaldsWhite
            )
            Text(text = "Your Current Balance", fontSize = 24.sp)

            Spacer(Modifier.size(48.dp))

            var amount by remember { mutableStateOf("") }
            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text(text = "Amount") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Row() {
                McButton(
                    onClick = {
                        try {
                            loggedInUser?.let { user ->
                            }
                            currentBalance.value = currentBalance.value?.plus(amount.toFloat())
                        } catch (e: NumberFormatException) {
                            Log.e("MainPage", "Invalid input for amount", e)
                        }
                    }
                ) {
                    Text(text = "Deposit")
                }
                Spacer(Modifier.padding(3.dp))
                SecondaryMcButton(
                    onClick = {
                        try {
                            loggedInUser?.let { user ->
                                updateBalance(user, user.balance + amount.toFloat())
                            }
                            currentBalance.value = currentBalance.value?.minus(amount.toFloat())
                        } catch (e: NumberFormatException) {
                            Log.e("MainPage", "Invalid input for amount", e)
                        }
                    }
                ) {
                    Text(text = "Withdrawal")
                }
            }
        }
    }
}



@Composable
fun PortraitLayout(navController: NavController) {
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
            Spacer(Modifier.size(16.dp))
            Text(
                text = "Welcome, ${loggedInUser?.username}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(Modifier.size(16.dp))
            McButton(
                onClick = {
                    navController.navigate("WelcomePage") {
                        popUpTo("WelcomePage") { inclusive = true }
                    }
                }
            ) {
                Text(text = "Log Out")
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$${currentBalance.value}",
                fontWeight = FontWeight.Bold,
                fontSize = 64.sp,
                lineHeight = 64.sp,
                color = if (!isSystemInDarkTheme()) McDonaldsGreen else McDonaldsWhite
            )
            Text(text = "Your Current Balance", fontSize = 24.sp)

            Spacer(Modifier.size(48.dp))

            var amount by remember { mutableStateOf("") }
            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text(text = "Amount") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Row() {
                McButton(
                    onClick = {
                        try {
                            loggedInUser?.let { user ->
                            }
                            currentBalance.value = currentBalance.value?.plus(amount.toFloat())
                        } catch (e: NumberFormatException) {
                            Log.e("MainPage", "Invalid input for amount", e)
                        }
                    }
                ) {
                    Text(text = "Deposit")
                }
                Spacer(Modifier.padding(3.dp))
                SecondaryMcButton(
                    onClick = {
                        try {
                            loggedInUser?.let { user ->
                                updateBalance(user, user.balance + amount.toFloat())
                            }
                            currentBalance.value = currentBalance.value?.minus(amount.toFloat())
                        } catch (e: NumberFormatException) {
                            Log.e("MainPage", "Invalid input for amount", e)
                        }
                    }
                ) {
                    Text(text = "Withdrawal")
                }
            }
        }
    }
}