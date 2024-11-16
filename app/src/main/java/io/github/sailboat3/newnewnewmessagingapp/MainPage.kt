package io.github.sailboat3.newnewnewmessagingapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.sailboat3.newnewnewmessagingapp.composables.McButton
import io.github.sailboat3.newnewnewmessagingapp.composables.SecondaryMcButton
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.McDonaldsGreen

@Composable
fun MainPage(navController: NavController) {

    var currentBalance by remember { mutableStateOf(loggedInUser?.balance) }

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
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "$$currentBalance", fontWeight = FontWeight.Bold, fontSize = 64.sp, lineHeight = 64.sp, color = McDonaldsGreen)
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
                            updateBalance(loggedInUser, loggedInUser!!.balance + amount.toFloat())
                            currentBalance = currentBalance?.plus(amount.toFloat())
                        } catch (e: NumberFormatException) {
                        }
                    }
                ) {
                    Text(text = "Deposit")
                }
                Spacer(Modifier.padding(3.dp))
                SecondaryMcButton(
                    onClick = {
                        try {
                            updateBalance(loggedInUser, loggedInUser!!.balance - amount.toFloat())
                            currentBalance = currentBalance?.minus(amount.toFloat())
                        } catch (e: NumberFormatException) {}
                    }
                ) {
                    Text(text = "Withdrawal")
                }
            }
        }
    }
}