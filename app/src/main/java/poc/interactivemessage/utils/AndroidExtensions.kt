package poc.interactivemessage.utils

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import android.util.TypedValue


class Paints {
    companion object {

        val Red: Paint = Paint()
        val Green: Paint = Paint()
        val White: Paint = Paint()
        val BlackAlpha50: Paint = Paint()
        val BlackAlpha100: Paint = Paint()
        val WhiteTextLarge: Paint = Paint()

        init {
            Red.color = Color.RED
            Green.color = Color.GREEN
            White.color = Color.WHITE
            BlackAlpha50.color = Color.BLACK
            BlackAlpha50.alpha = 50

            BlackAlpha100.color = Color.BLACK
            BlackAlpha100.alpha = 100

            WhiteTextLarge.textSize = dpToPx(24f)
        }
    }
}

fun dpToPx(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().displayMetrics)
}