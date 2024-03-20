package dev.boringx.thememodeswitch

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


// TODO: 1. Get available sizes, then:
//       Set 2. sun to left side,
//           3. moon to right side
@Composable
fun SunToMoon(
    enabled: MutableState<Boolean>,
    sunColor: Color = Color.Yellow,
    moonColor: Color = Color.Gray
) {
    with(enabled.value) {
        val color: Color by animateColorAsState(if (this) moonColor else sunColor)
        val center: Float by animateFloatAsState(if (this) 250f else 100f)
        val intersectRadius: Float by animateFloatAsState(if (this) 100f else 0f)

        Canvas(modifier = Modifier
            .fillMaxSize()
            .clickable { enabled.value = !this }
        ) {
            drawSunToMoonWithPath(color = color, center = center, intersectRadius = intersectRadius)
        }
    }
}

@Preview
@Composable
fun PreviewSunToMoon() {
//    SunToMoon()
}
