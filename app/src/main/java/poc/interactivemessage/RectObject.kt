package poc.interactivemessage

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class RectObject() : MessageObject() {

    private val paint: Paint = Paint()

    init {
        paint.color = Color.GREEN
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRect(x, y, x + width, y + height, paint)
    }
}