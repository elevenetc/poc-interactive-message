package poc.interactivemessage

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class GridObject : MessageObject() {

    val paint: Paint = Paint()

    init {
        paint.color = Color.BLACK
        paint.alpha = 50
    }

    override fun draw(canvas: Canvas) {
        val step = 50
        val w = canvas.width / step
        val h = canvas.height / step

        (0..w)
                .map { (step * it).toFloat() }
                .forEach { canvas.drawLine(it, 0f, it, canvas.height.toFloat(), paint) }

        (0..h)
                .map { (step * it).toFloat() }
                .forEach { canvas.drawLine(0f, it, canvas.width.toFloat(), it, paint) }
    }

    override fun isInBounds(x: Float, y: Float): Boolean {
        return false
    }
}