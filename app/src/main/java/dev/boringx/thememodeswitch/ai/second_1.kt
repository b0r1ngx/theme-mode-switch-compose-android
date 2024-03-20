package dev.boringx.thememodeswitch.ai

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SunAndMoonSwitcher21() {
    var isSun by remember { mutableStateOf(true) }

    val transition = updateTransition(targetState = isSun, label = "Sun Moon Transition")
    val color by transition.animateColor(
        label = "Color Transition"
    ) { isSun ->
        if (isSun) Color(0xFF87CEEB) else Color(0xFF000022)
    }
    val sweepAngle by transition.animateFloat(
        label = "Sweep Angle Transition"
    ) { isSun ->
        if (isSun) 180f else 180f
    }

    Surface(color = color) {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .clickable { isSun = !isSun }
        ) {
            if (isSun) {
                drawSun(sweepAngle)
            } else {
                drawMoon(sweepAngle)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DrawSunAndMoon(sweepAngle: Float) {
    AnimatedContent(
        targetState = sweepAngle,
        transitionSpec = {
            fadeIn() with slideOutVertically()
        }
    ) { angle ->
        if (sweepAngle > 90) {
//            drawSun(angle)
        } else {
//            drawMoon(angle)
        }
    }
}

private fun DrawScope.drawSun(sweepAngle: Float) {
    val sunColor = Color.Yellow
    val sunRadius = 100f
    val sunCenterX = 200f
    val sunCenterY = 200f

    drawArc(
        color = sunColor,
        startAngle = 0f,
        sweepAngle = sweepAngle,
        topLeft = Offset(sunCenterX - sunRadius, sunCenterY - sunRadius),
        size = Size(sunRadius * 2, sunRadius * 2),
        useCenter = true
    )
}

private fun DrawScope.drawMoon(sweepAngle: Float) {
    val moonColor = Color.White
    val moonRadius = 100f
    val moonCenterX = 200f
    val moonCenterY = 200f

    drawArc(
        color = moonColor,
        startAngle = 180f,
        sweepAngle = sweepAngle,
        topLeft = Offset(moonCenterX - moonRadius, moonCenterY - moonRadius),
        size = Size(moonRadius * 2, moonRadius * 2),
        useCenter = true
    )
}

@Preview
@Composable
private fun PreviewSunAndMoonSwitcher21() {
    SunAndMoonSwitcher21()
}
