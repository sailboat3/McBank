package io.github.sailboat3.newnewnewmessagingapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/*
I tried to persist data on app restart, but I could not get it to work. After trying Sqlite (room) and
SharedPreferences, I still could not get it to work. It's persistent if you don't close the app.
*/

class UserAccount(
    val username: String,
    val password: String,
    var balance: Double
)

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
