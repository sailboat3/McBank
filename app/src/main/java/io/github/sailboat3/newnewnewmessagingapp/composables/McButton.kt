package io.github.sailboat3.newnewnewmessagingapp.composables


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.McDonaldsBlack
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.McDonaldsGreen
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.McDonaldsRed
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.McDonaldsWhite
import io.github.sailboat3.newnewnewmessagingapp.ui.theme.McDonaldsYellow

@Composable
fun McButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = McDonaldsYellow,
            contentColor = McDonaldsBlack
        ),
        shape = RoundedCornerShape(4.dp) // Set small radius for rounded corners
    ) {
        content()
    }
}

@Composable
fun SecondaryMcButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = McDonaldsRed,
            contentColor = McDonaldsWhite
        ),
        shape = RoundedCornerShape(4.dp) // Set small radius for rounded corners
    ) {
        content()
    }
}

@Composable
fun TertiaryMcButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = McDonaldsGreen,
            contentColor = McDonaldsWhite
        ),
        shape = RoundedCornerShape(4.dp) // Set small radius for rounded corners
    ) {
        content()
    }
}