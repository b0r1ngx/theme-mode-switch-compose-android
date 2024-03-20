package dev.boringx.thememodeswitch

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Sun -> Moon
// ☀️ -> 🌒 / 🌙 / 🌛
@Composable
fun ThemeModeSwitch(modifier: Modifier = Modifier) {
    val enabled = remember { mutableStateOf(false) }

    val lightSkyColor = Color(0xFF21b0fe)
    val darkSkyColor = Color(0xFF0d3b66)
    val backgroundColor: Color by animateColorAsState(if (enabled.value) darkSkyColor else lightSkyColor)

    Box(
        modifier = modifier
            .size(width = 200.dp, height = 100.dp)
            .clip(RoundedCornerShape(50))
            .background(color = backgroundColor)
            .padding(all = 20.dp)
    ) {
        SunToMoon(enabled)
    }
}