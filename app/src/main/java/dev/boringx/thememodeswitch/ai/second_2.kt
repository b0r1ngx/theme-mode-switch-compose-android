import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
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
fun SunAndMoonSwitcher22() {
    var isSun by remember { mutableStateOf(true) }

    val transition = updateTransition(targetState = isSun, label = "SunMoonTransition")

    val rotationAngle by transition.animateFloat(
        label = "RotationAngle"
    ) { isSun ->
        if (isSun) 0f else 180f
    }

    val sunAlpha by transition.animateFloat(
        label = "SunAlpha",
        transitionSpec = {
            if (targetState) {
                keyframes {
                    durationMillis = 500
                    0f at 0 using LinearOutSlowInEasing // Fade out the sun
                    1f at 250 // Keep the sun invisible during rotation
                    1f at 500 using FastOutSlowInEasing // Fade in the moon
                }
            } else {
                keyframes {
                    durationMillis = 500
                    1f at 0 using LinearOutSlowInEasing // Fade out the moon
                    1f at 250 // Keep the moon invisible during rotation
                    0f at 500 using FastOutSlowInEasing // Fade in the sun
                }
            }
        },
        targetValueByState = { isSun -> if (isSun) 0f else 1f }
    )

    val backgroundColor by transition.animateColor(
        label = "BackgroundColor"
    ) { isSun ->
        if (isSun) Color(0xFF87CEEB) else Color(0xFF000022)
    }

    Canvas(modifier = Modifier
        .fillMaxSize()
        .clickable { isSun = !isSun }
    ) {
        drawRect(color = backgroundColor)

        if (isSun) {
            drawSun(rotationAngle, sunAlpha)
        } else {
            drawMoon(rotationAngle, sunAlpha)
        }
    }
}

private fun DrawScope.drawSun(rotationAngle: Float, alpha: Float) {
    val sunColor = Color.Yellow
    val sunRadius = size.minDimension / 4
    val sunCenterX = size.width / 2
    val sunCenterY = size.height / 3

    drawArc(
        color = sunColor.copy(alpha = alpha),
        startAngle = 0f + rotationAngle,
        sweepAngle = 180f,
        topLeft = Offset(sunCenterX - sunRadius, sunCenterY - sunRadius),
        size = Size(sunRadius * 2, sunRadius * 2),
        useCenter = true
    )
}

private fun DrawScope.drawMoon(rotationAngle: Float, alpha: Float) {
    val moonColor = Color.White
    val moonRadius = size.minDimension / 4
    val moonCenterX = size.width / 2
    val moonCenterY = size.height / 3

    drawArc(
        color = moonColor.copy(alpha = alpha),
        startAngle = 180f + rotationAngle,
        sweepAngle = 180f,
        topLeft = Offset(moonCenterX - moonRadius, moonCenterY - moonRadius),
        size = Size(moonRadius * 2, moonRadius * 2),
        useCenter = true
    )
}

@Preview
@Composable
fun PreviewSunAndMoonSwitcher22() {
    SunAndMoonSwitcher22()
}
