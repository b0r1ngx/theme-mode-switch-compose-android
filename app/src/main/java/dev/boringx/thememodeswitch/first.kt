package dev.boringx.thememodeswitch

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
fun SunToMoonSwitch(modifier: Modifier = Modifier) {
    var isSun by remember { mutableStateOf(true) }

    val backgroundColor = if (isSun) Color(0xFF87CEEB) else Color(0xFF000022)

    Canvas(modifier = modifier
        .fillMaxSize()
        .clickable {
            isSun = !isSun
        }) {
        drawRect(color = backgroundColor)

        if (isSun) drawSun() else drawMoon()
    }
}

private fun DrawScope.drawSun() {
    val sunColor = Color.Yellow
    val sunRadius = size.minDimension / 4
    val sunCenterX = size.width / 2
    val sunCenterY = size.height / 3

    drawArc(
        color = sunColor,
        startAngle = 0f,
        sweepAngle = 180f,
        topLeft = Offset(sunCenterX - sunRadius, sunCenterY - sunRadius),
        size = Size(sunRadius * 2, sunRadius * 2),
        useCenter = true
    )
}

private fun DrawScope.drawMoon() {
    val moonColor = Color.White
    val moonRadius = size.minDimension / 4
    val moonCenterX = size.width / 2
    val moonCenterY = size.height / 3

    drawArc(
        color = moonColor,
        startAngle = 180f,
        sweepAngle = 180f,
        topLeft = Offset(moonCenterX - moonRadius, moonCenterY - moonRadius),
        size = Size(moonRadius * 2, moonRadius * 2),
        useCenter = true
    )
}

@Preview
@Composable
private fun PreviewSunToMoonSwitch() {
    SunToMoonSwitch()
}