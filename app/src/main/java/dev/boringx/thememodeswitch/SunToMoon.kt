package dev.boringx.thememodeswitch

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SunToMoon() {

    val sunColor = Color.Yellow
    val moonColor = Color.Gray

    var enabled by remember { mutableStateOf(false) }
    val color: Color by animateColorAsState(if (enabled) moonColor else sunColor)
    val center: Float by animateFloatAsState(if (enabled) 250f else 100f)
    val intersectRadius: Float by animateFloatAsState(if (enabled) 100f else 0f)

    Canvas(modifier = Modifier
        .fillMaxSize()
        .clickable { enabled = !enabled }
    ) {
        drawSunToMoonWithPath(color = color, center = center, intersectRadius = intersectRadius)
    }
}

fun DrawScope.drawSunToMoon(
    radius: Float = 100f,
    color: Color,
    center: Float,
    intersectRadius: Float
) {
    val moonCenterX = center
    val moonCenterY = size.height / 2

    // Draw the full circle of the moon
    drawCircle(
        color = color,
        center = Offset(moonCenterX, moonCenterY),
        radius = radius
    )

    drawCircle(
        color = Color.White, // background color
        center = Offset(moonCenterX - 50, moonCenterY),
        radius = intersectRadius
    )
}

@Preview
@Composable
fun PreviewSunToMoon() {
    SunToMoon()
}
