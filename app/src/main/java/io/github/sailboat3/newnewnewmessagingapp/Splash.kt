package io.github.sailboat3.newnewnewmessagingapp

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun Splash(navController: NavController) {
    // Initialize MediaPlayer with your jingle audio file.
    val context = LocalContext.current
    var startAnimation by remember { mutableStateOf(false) }
    val mediaPlayer = MediaPlayer.create(context, R.raw.jingle)


    LaunchedEffect(key1 = true) {  // LaunchedEffect needs a key; true is simple and static
        mediaPlayer.start()         // Play the jingle
        delay(3000)                 // Adjust to match the length of your jingle

        mediaPlayer.release()       // Free resources after playing
        navController.navigate("WelcomePage") {
            popUpTo("Splash") { inclusive = true }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mcdonalds_logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(150.dp) // Adjust size as needed
        )
        Text(
            text = "McBank",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
