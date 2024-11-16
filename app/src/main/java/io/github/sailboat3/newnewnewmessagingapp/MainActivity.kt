package io.github.sailboat3.newnewnewmessagingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.NewNewNewMessagingAppTheme

// I tried to persist data on app restart, but I could not get it to work. After trying Sqlite (room) and SharedPreferences, I still could not get it to work.
// It's persistent if you don't close the app.

class UserAccount(val username: String, val password: String, var balance: Double)

val initialAccount = UserAccount(username = "McUser", password = "1234", balance = 1987.65)

var currentAccounts: MutableState<List<UserAccount>> = mutableStateOf(listOf(initialAccount))

var loggedInUser: UserAccount? = null

fun addUser(username: String, password: String) {
    val user = UserAccount(username, password, 0.0)
    currentAccounts.value = currentAccounts.value + user
}

fun getUser(username: String): UserAccount? {
    for (account in currentAccounts.value) {
        if (account.username == username) {
            return account
        }
    }
    return null
}

fun updateBalance(account: UserAccount?, newBalance: Double) {
    account?.balance = newBalance
    currentAccounts.value = currentAccounts.value.toList()
}

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