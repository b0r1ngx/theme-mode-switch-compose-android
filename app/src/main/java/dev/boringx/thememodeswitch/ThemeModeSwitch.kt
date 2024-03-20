package dev.boringx.thememodeswitch

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Canvas
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun ThemeModeSwitch(
    modifier: Modifier = Modifier
) {
    // Sun -> Moon
    // ☀️ -> 🌒 / 🌙 / 🌛
    val drawable = AnimatedImageVector.animatedVectorResource(R.drawable.ic_launcher_foreground)
    var atEnd by remember { mutableStateOf(false) }

    IconButton(onClick = { atEnd = !atEnd }) {
        Icon(
            painter = rememberAnimatedVectorPainter(animatedImageVector = drawable, atEnd = atEnd),
            contentDescription = null
        )

    }
    Canvas(modifier = modifier) {
//        drawArc(
//            color = Color.Yellow
//        )
//
//        drawArc(
//            color = Color.Gray
//        )
//        drawCircle(color = Color.Yellow)
    }
}