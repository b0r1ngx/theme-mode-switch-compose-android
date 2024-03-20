package dev.boringx.thememodeswitch

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.drawscope.DrawScope

fun DrawScope.drawSunToMoonWithPath(
    radius: Float = 100f,
    color: Color,
    center: Float,
    intersectRadius: Float
) {
    val moonCenterX = center
    val moonCenterY = size.height / 2

    val tempPath1 = Path().apply {
        addOval(
            Rect(
                radius = radius,
                center = Offset(moonCenterX, moonCenterY)
            )
        )
    }

    val tempPath2 = Path().apply {
        addOval(
            Rect(
                radius = intersectRadius,
                center = Offset(moonCenterX  - 50, moonCenterY)
            )
        )
    }

    val diffPath = Path.combine(
        operation = PathOperation.Difference,
        path1 = tempPath1,
        path2 = tempPath2
    )

    drawPath(path = diffPath, color = color)
    // default circle
//    drawPath(path = tempPath1, color = color)
}
