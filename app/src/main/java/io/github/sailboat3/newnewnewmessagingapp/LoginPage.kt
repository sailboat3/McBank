package io.github.sailboat3.newnewnewmessagingapp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.sailboat3.newnewnewmessagingapp.composables.McButton

// This page handles both account creation and login


@Composable
fun LoginPage(
    navController: NavController,
    createAccount: Boolean
) {
    val context = LocalContext.current
    var captchaChecked by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(Modifier.size(64.dp))
        if (createAccount) {
            Text(text = "Welcome to McBank!", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(text = "Let's Make an Account")
        } else {
            Text(text = "Welcome Back!", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
        Spacer(Modifier.size(16.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") }
        )

        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            }
        )
        Row(
            modifier = Modifier
                .padding(4.dp)
        ) {
            var checked by remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it; captchaChecked = checked }
            )
            Text(
                modifier = Modifier.padding(12.dp),
                text = "I'm not a robot"
            )
        }
        McButton(
            onClick = {
                if (captchaChecked) {
                    if (createAccount) {
                        addUser(username, password)
                        loginPageState = false
                        navController.navigate("LoginPage") {
                            popUpTo("LoginPage") { inclusive = true }
                        }
                        Toast.makeText(context, "User Added", Toast.LENGTH_SHORT).show()
                    } else {
                        if (getUser(username) != null) {
                            loggedInUser = getUser(username)
                            navController.navigate("MainPage") {
                                popUpTo("MainPage") { inclusive = true }
                            }
                            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Incorrect Username/Password", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(context, "Robots not allowed", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = if (createAccount) "Let's Go!" else "Log in")
        }
    }
}